package com.example.kotlinauthflow.domain

interface AuthRepository{
    suspend fun loginWithEmail(email: String, password: String): AuthResult
    suspend fun loginWithPhone(phone: String): AuthResult
    suspend fun loginWithGoogle(): AuthResult
    fun logout()
}