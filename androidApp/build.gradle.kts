plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(project(":shared"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.0")

    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation( "androidx.core:core-ktx:1.3.2")
    implementation( "androidx.activity:activity-ktx:1.2.0-alpha08")
    implementation( "androidx.fragment:fragment-ktx:1.3.0-alpha08")
    implementation( "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    implementation( "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("com.google.android.material:material:1.3.0")
}

android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "io.github.hkusu.kmmsampleapp.androidApp"
        minSdkVersion(23)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}