package io.github.hkusu.kmmsampleapp.shared.data.api

import io.github.hkusu.kmmsampleapp.shared.data.api.response.GitHubUserResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get

internal class GitHubApi(private val httpClient: HttpClient) {

    suspend fun getUserList(): List<GitHubUserResponse> {
        return httpClient.get("${BASE_URL}/users")
    }

    companion object {
        private const val BASE_URL = "https://api.github.com"
    }
}
