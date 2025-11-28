package com.example.kotlinauthflow.data.services

import com.example.kotlinauthflow.domain.AuthService
import com.example.kotlinauthflow.domain.GoogleAuthService
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import jakarta.inject.Inject
import kotlinx.coroutines.tasks.await

class GoogleAuthServiceImpl @Inject constructor(private val firebaseAuth: FirebaseAuth) :
    GoogleAuthService {
    override suspend fun firebaseAuthWithGoogle(idToken: String): Result<Unit> {
        return try {
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            firebaseAuth.signInWithCredential(credential).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
