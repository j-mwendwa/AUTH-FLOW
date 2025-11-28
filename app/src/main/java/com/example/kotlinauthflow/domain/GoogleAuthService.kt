package com.example.kotlinauthflow.domain

interface GoogleAuthService{
    suspend fun  firebaseAuthWithGoogle(idToken: String): Result<Unit>


}