package io.github.hkusu.kmmsampleapp.shared.model.repository

import io.github.hkusu.kmmsampleapp.shared.model.User

interface UserRepository {
    suspend fun getUserList(): List<User>
}
