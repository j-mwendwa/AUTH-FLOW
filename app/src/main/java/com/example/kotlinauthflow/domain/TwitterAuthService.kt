package com.example.kotlinauthflow.domain

interface TwitterAuthService{
    suspend fun twitterLogin(accessToken: String, accessSecret: String): Result<Unit>

}