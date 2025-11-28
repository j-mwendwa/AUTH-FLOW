package com.example.kotlinauthflow.domain

interface FacebookAuthService{
    suspend fun facebookLogin(accessToken: String): Result<Unit>

}