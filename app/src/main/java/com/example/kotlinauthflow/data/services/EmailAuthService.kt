package com.example.kotlinauthflow.data.services

import com.example.kotlinauthflow.domain.AuthService
import jakarta.inject.Inject

class EmailAuthService @Inject constructor() : AuthService {

    override suspend fun login(email: String, password: String): Boolean{
        return email == "william.paterson@my-own-personal-domain.com" && password == "password"
    }

    override suspend fun login(phone: String): Boolean {
        return false
    }
    override suspend fun login (): Boolean {
        return false
    }

    override fun logout() {
        println("Logging out")
    }

}