package com.example.kotlinauthflow.domain

/*Simple Auth-Services will be email and login for know,they will inherit from the AuthResult*/

interface AuthService{
    suspend fun login(email: String, password: String): AuthResult
    suspend fun register(email: String, password: String): AuthResult

}
//Overloading -> Multiple functions with same name but different parameters
//Phone,email and google have the same name but with different parameters.