package io.github.hkusu.kmmsampleapp.shared

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.hkusu.kmmsampleapp.shared.data.api.GitHubApi
import io.github.hkusu.kmmsampleapp.shared.data.repository.UserRepositoryImpl
import io.github.hkusu.kmmsampleapp.shared.model.GetUserUseCase
import io.github.hkusu.kmmsampleapp.shared.model.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object Module {

    @Provides
    fun provideGitHubApi(): GitHubApi {
        return GitHubApi(CommonModule.httpClient)
    }

    @Provides
    @Singleton
    fun provideUserRepository(gitHubApi: GitHubApi): UserRepository {
        return UserRepositoryImpl(gitHubApi)
    }

    @Provides
    fun provideGetUserUseCase(userRepository: UserRepository): GetUserUseCase {
        return GetUserUseCase(userRepository)
    }
}
