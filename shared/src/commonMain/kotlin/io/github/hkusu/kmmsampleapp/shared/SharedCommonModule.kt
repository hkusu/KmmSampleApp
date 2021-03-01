package io.github.hkusu.kmmsampleapp.shared

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.serialization.json.Json

private fun createHttpClient(): HttpClient {
    return HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(json = Json {
                ignoreUnknownKeys = true
            })
        }
    }
}

object SharedCommonModule {
    // singleton
    val httpClient: HttpClient by lazy {
        createHttpClient()
    }

    // singleton にしない場合
    // val httpClient: HttpClient
    //     get() = createHttpClient()
}
