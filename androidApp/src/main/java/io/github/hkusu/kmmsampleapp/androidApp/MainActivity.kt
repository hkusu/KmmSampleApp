package io.github.hkusu.kmmsampleapp.androidApp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import io.github.hkusu.kmmsampleapp.shared.GitHubApi
import io.github.hkusu.kmmsampleapp.shared.HogeFuga
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    @Inject
    lateinit var hoge: HogeFuga

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            val tv: TextView = findViewById(R.id.text_view)
            tv.text = GitHubApi().getUserList().map { it.login }.joinToString("\n")
        }

        hoge.hello()
    }
}
