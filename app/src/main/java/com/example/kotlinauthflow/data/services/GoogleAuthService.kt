package com.example.kotlinauthflow.data.services

import com.example.kotlinauthflow.domain.AuthService

class GoogleAuthService : AuthService{

    override suspend fun login(email: String, password: String): Boolean {

        return false
    }

    override suspend fun login (phone: String): Boolean {
        return false
    }
    override suspend fun login(): Boolean {
        println("Google SignIn")
        return true
    }

    override fun logout() {
        println("Google Logout")
    }
}