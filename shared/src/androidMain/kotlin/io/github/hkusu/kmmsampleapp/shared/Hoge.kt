package io.github.hkusu.kmmsampleapp.shared

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HogeFuga @Inject constructor() {
    fun hello() {
        Log.d("dagger-test", "hello!!")
    }
}
