package io.github.hkusu.kmmsampleapp.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.hkusu.kmmsampleapp.shared.Greeting
import android.widget.TextView

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()
    }
}
