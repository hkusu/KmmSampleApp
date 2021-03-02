package io.github.hkusu.kmmsampleapp.shared.data.repository

import io.github.hkusu.kmmsampleapp.shared.data.api.GitHubApi
import io.github.hkusu.kmmsampleapp.shared.data.api.response.GitHubUserResponse
import io.github.hkusu.kmmsampleapp.shared.model.User
import io.github.hkusu.kmmsampleapp.shared.model.repository.UserRepository

internal class UserRepositoryImpl(private val gitHubApi: GitHubApi) : UserRepository {

    override suspend fun getUserList(): List<User> {
        return gitHubApi.getUserList().map(GitHubUserResponse::toUser)
    }
}

// テストコードの為に公開
internal fun GitHubUserResponse.toUser(): User {
    return this.run {
        User(
            name = login
        )
    }
}
