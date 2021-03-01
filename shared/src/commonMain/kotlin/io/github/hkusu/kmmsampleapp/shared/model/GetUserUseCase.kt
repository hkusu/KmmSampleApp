package io.github.hkusu.kmmsampleapp.shared.model

import io.github.hkusu.kmmsampleapp.shared.model.repository.UserRepository

class GetUserUseCase(private val userRepository: UserRepository) {

    suspend operator fun invoke(): List<User> {
        return userRepository.getUserList()
    }
}
