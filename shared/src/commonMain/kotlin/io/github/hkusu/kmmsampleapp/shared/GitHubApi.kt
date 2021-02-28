package io.github.hkusu.kmmsampleapp.shared

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class User(
    @SerialName("login")
    val login: String,
    @SerialName("avatar_url")
    val avatarUrl: String,
    @SerialName("html_url")
    val htmlUrl: String,
)

class GitHubApi {

    private val client: HttpClient = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(json = Json {
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getUserList(): List<User> {
        return client.get("$BASE_URL/users")
    }

    companion object {
        private const val BASE_URL = "https://api.github.com"
    }
}
