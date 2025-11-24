package com.example.kotlinauthflow.data.services

import com.example.kotlinauthflow.domain.AuthService

class PhoneAuthService : AuthService{

    override suspend fun login(email: String, password: String): Boolean {
        return false
    }

    override suspend fun login(phone: String): Boolean {
        println("Sending OTP to $phone")
        return true
    }

    override suspend fun login():Boolean {
        return false
    }

    override fun logout() {
        println("Logging out")
    }
}