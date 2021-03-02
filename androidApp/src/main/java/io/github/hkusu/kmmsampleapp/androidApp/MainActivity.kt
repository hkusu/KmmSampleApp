package io.github.hkusu.kmmsampleapp.androidApp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import io.github.hkusu.kmmsampleapp.androidApp.databinding.ActivityMainBinding
import io.github.hkusu.kmmsampleapp.androidApp.databinding.ActivityMainBinding.bind

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.userList.observe(this) {
            binding.textView.text = it.map { it.name }.joinToString("\n")
        }
    }
}
