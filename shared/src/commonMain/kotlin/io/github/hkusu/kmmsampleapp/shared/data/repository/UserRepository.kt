package io.github.hkusu.kmmsampleapp.shared.data.repository

import io.github.hkusu.kmmsampleapp.shared.data.api.GitHubApi
import io.github.hkusu.kmmsampleapp.shared.data.api.response.GitHubUserResponse
import io.github.hkusu.kmmsampleapp.shared.model.User

class UserRepository(private val gitHubApi: GitHubApi) {

    suspend fun getUserList(): List<User> {
        return gitHubApi.getUserList().map(GitHubUserResponse::toUser)
    }
}

fun GitHubUserResponse.toUser(): User {
    return this.run {
        User(
            name = login
        )
    }
}
