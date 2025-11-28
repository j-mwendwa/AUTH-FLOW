package com.example.kotlinauthflow.data.services

import com.example.kotlinauthflow.domain.FacebookAuthService
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import jakarta.inject.Inject
import kotlinx.coroutines.tasks.await

class FacebookAuthServiceImpl @Inject constructor(private val firebaseAuth: FirebaseAuth) : FacebookAuthService {

    override suspend fun facebookLogin(accessToken: String): Result<Unit> {
        return try {
            val credential = FacebookAuthProvider.getCredential(accessToken)
            firebaseAuth.signInWithCredential(credential).await()
            Result.success(Unit)
        } catch (e: Exception){
            Result.failure(e)
        }
        }
    }