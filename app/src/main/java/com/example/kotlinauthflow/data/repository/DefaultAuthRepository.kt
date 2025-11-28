package com.example.kotlinauthflow.data.repository

import com.example.kotlinauthflow.domain.AuthRepository
import com.example.kotlinauthflow.domain.AuthService
import jakarta.inject.Inject

class DefaultAuthRepository @Inject constructor(private val service: AuthService): AuthRepository {

    override suspend fun login(email: String, password: String) =
        service.login(email, password)

    // override suspend fun loginWithPhone(phone: String) =


    override suspend fun register(email: String, password: String) =
        service.register(email, password)

    //override fun logout() {
    // service.logout()
    //}
}