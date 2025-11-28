package com.example.kotlinauthflow.domain

interface AuthRepository{
    suspend fun login(email: String, password: String): Result<Unit>

    //suspend fun loginWithPhone(phone: String)
    suspend fun register(email: String, password: String): Result<Unit>
    //fun logout()
}//()
 //   fun logout()
//}