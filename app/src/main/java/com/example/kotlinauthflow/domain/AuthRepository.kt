package com.example.kotlinauthflow.domain

import jakarta.inject.Inject

interface AuthRepository {
    suspend fun login(email: String, password: String): Result<Unit>

    //suspend fun loginWithPhone(phone: String)
    suspend fun register(email: String, password: String): Result<Unit>

    suspend fun googleLogin(idToken: String): Result<Unit>

    suspend fun facebookLogin(accessToken: String): Result<Unit>

    suspend fun twitterLogin(accessToken: String, accessSecret: String): Result<Unit>



    //fun logout()
}//()
 //   fun logout()
//}