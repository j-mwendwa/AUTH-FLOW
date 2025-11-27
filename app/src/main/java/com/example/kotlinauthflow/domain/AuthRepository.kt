package com.example.kotlinauthflow.domain

interface AuthRepository{
    suspend fun login(email: String, password: String): AuthResult

    //suspend fun loginWithPhone(phone: String)
    suspend fun register(email: String, password: String): AuthResult
    //fun logout()
}//()
 //   fun logout()
//}