package com.example.kotlinauthflow.data.di

import com.example.kotlinauthflow.data.repository.DefaultAuthRepository
import com.example.kotlinauthflow.data.services.EmailAuthService
import com.example.kotlinauthflow.data.services.GoogleAuthServiceImpl
import com.example.kotlinauthflow.domain.AuthService
import com.example.kotlinauthflow.domain.GoogleAuthService
import com.example.kotlinauthflow.domain.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides @Singleton
    fun provideEmailService(auth: FirebaseAuth): AuthService = EmailAuthService(auth)

    @Provides @Singleton
    fun provideGoogleService(auth: FirebaseAuth): GoogleAuthService = GoogleAuthServiceImpl(auth)

    @Provides @Singleton
    fun provideRepository(
        email: AuthService,
        google: GoogleAuthService
    ) = DefaultAuthRepository(email, google)
}