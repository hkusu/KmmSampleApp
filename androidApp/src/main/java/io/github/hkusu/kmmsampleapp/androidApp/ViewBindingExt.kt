package io.github.hkusu.kmmsampleapp.androidApp

import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

// ref: https://zenn.dev/hkusu/articles/cf9357b3549c8c

inline fun <T : ViewBinding> FragmentActivity.viewBinding(crossinline block: View.() -> T): ReadOnlyProperty<FragmentActivity, T> {
    return object : ReadOnlyProperty<FragmentActivity, T> {
        private var binding: T? = null
        override fun getValue(thisRef: FragmentActivity, property: KProperty<*>): T {
            val view = thisRef.findViewById<ViewGroup>(android.R.id.content)[0]
            return binding ?: block.invoke(view).apply { binding = this }
        }
    }
}

inline fun <reified T : ViewBinding> Fragment.viewBinding(crossinline block: View.() -> T): ReadOnlyProperty<Fragment, T?> {
    return object : ReadOnlyProperty<Fragment, T?> {
        override fun getValue(thisRef: Fragment, property: KProperty<*>): T? {
            val view = thisRef.view ?: return null
            val key = T::class.java.name.hashCode()
            @Suppress("UNCHECKED_CAST")
            return view.getTag(key) as? T ?: block.invoke(view).apply { view.setTag(key, this) }
        }
    }
}
