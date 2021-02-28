package io.github.hkusu.kmmsampleapp.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import io.github.hkusu.kmmsampleapp.shared.GitHubApi
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            val tv: TextView = findViewById(R.id.text_view)
            tv.text = GitHubApi().getUserList().map { it.login }.joinToString("\n")
        }
    }
}
