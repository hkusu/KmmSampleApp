package io.github.hkusu.kmmsampleapp.shared.model

import io.github.hkusu.kmmsampleapp.shared.model.repository.UserRepository

class GetUserUseCase internal constructor(private val userRepository: UserRepository) {

    suspend operator fun invoke(): List<User> {
        return userRepository.getUserList()
    }
}
