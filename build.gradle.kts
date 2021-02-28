buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.30")
        classpath("com.android.tools.build:gradle:4.1.2")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.4.30")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.31.2-alpha")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}
