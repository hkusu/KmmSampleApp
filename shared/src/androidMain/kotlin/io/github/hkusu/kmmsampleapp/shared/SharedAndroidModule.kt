package io.github.hkusu.kmmsampleapp.shared

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.hkusu.kmmsampleapp.shared.data.api.GitHubApi
import io.github.hkusu.kmmsampleapp.shared.data.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedAndroidModule {

    @Provides
    @Singleton
    fun provideGitHubApi(): GitHubApi {
        return GitHubApi(SharedCommonModule.httpClient)
    }

    @Provides
    @Singleton
    fun provideUserRepository(gitHubApi: GitHubApi): UserRepository {
        return UserRepository(gitHubApi)
    }
}
