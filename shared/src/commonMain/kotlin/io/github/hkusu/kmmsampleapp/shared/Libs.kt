package io.github.hkusu.kmmsampleapp.shared

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.serialization.json.Json

internal object Libs {

    // singleton
    internal val httpClient: HttpClient by lazy {
        HttpClient {
            install(JsonFeature) {
                serializer = KotlinxSerializer(json = Json {
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    // singleton にしない場合
    // val httpClient: HttpClient
    //     get() {
    //         return HttpClient {
    //             install(JsonFeature) {
    //                 serializer = KotlinxSerializer(json = Json {
    //                     ignoreUnknownKeys = true
    //                 })
    //             }
    //         }
    //     }
}
