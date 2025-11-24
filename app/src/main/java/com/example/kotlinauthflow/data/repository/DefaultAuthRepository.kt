package com.example.kotlinauthflow.data.repository

import com.example.kotlinauthflow.domain.AuthRepository
import com.example.kotlinauthflow.domain.AuthResult
import com.example.kotlinauthflow.domain.AuthService

class DefaultAuthRepository (private val service: AuthService): AuthRepository {

    override suspend fun loginWithEmail(email: String, password: String): AuthResult {
        return if (service.login(email, password)) AuthResult.Success
        else AuthResult.Error("Something went wrong")
    }

    override suspend fun loginWithPhone(phone: String): AuthResult {
        return if (service.login(phone)) AuthResult.Success
        else AuthResult.Error("Something went wrong")

    }

    override suspend fun loginWithGoogle(): AuthResult {
        return if (service.login()) AuthResult.Success
        else AuthResult.Error("Google login failed")
    }

    override fun logout() {
        service.logout()
    }
}