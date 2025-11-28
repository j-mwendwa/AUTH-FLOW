package com.example.kotlinauthflow.data.services

import com.example.kotlinauthflow.domain.TwitterAuthService
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.TwitterAuthProvider
import jakarta.inject.Inject
import kotlinx.coroutines.tasks.await

class FacebookAuthServiceImpl @Inject constructor(private val firebaseAuth: FirebaseAuth): TwitterAuthService{

    override suspend fun twitterLogin(accessToken: String, accessSecret: String): Result<Unit> {
        val credential = TwitterAuthProvider.getCredential(accessToken, accessSecret)
        return try {
            firebaseAuth.signInWithCredential(credential).await()
            Result.success(Unit)
        }catch (e: Exception){
            Result.failure(e)
        }


    }

}