package com.example.kotlinauthflow.data.di

import com.example.kotlinauthflow.data.services.EmailAuthService
import com.example.kotlinauthflow.domain.AuthService
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
    @InstallIn(SingletonComponent::class)
object AuthModule {
    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()

        @Provides
        @Singleton
        fun provideAuthService(auth: FirebaseAuth): AuthService = EmailAuthService(auth)

        @Provides
        @Singleton
        fun provideRepository(service: AuthService) =
            com.example.kotlinauthflow.domain.AuthRepository(service)
    }
}