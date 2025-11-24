package com.example.kotlinauthflow.data.di

import androidx.core.view.WindowInsetsCompat
import com.example.kotlinauthflow.data.repository.DefaultAuthRepository
import com.example.kotlinauthflow.domain.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindAuthRepository(
        impl: DefaultAuthRepository): AuthRepository

}