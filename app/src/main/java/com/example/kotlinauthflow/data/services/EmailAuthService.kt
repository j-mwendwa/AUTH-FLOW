package com.example.kotlinauthflow.data.services

import com.example.kotlinauthflow.domain.AuthResult
import com.example.kotlinauthflow.domain.AuthService
import com.google.firebase.auth.FirebaseAuth
import jakarta.inject.Inject
import kotlinx.coroutines.tasks.await

class EmailAuthService @Inject constructor(private val firebaseAuth: FirebaseAuth) : AuthService {

    override suspend fun login(email: String, password: String): AuthResult {
       return try {
            firebaseAuth.signInWithEmailAndPassword(email, password).await()
           AuthResult.Success
        } catch (e: Exception) {
           AuthResult.Error(e.message ?: "Something went wrong")
           }
        }
        override suspend fun register(email: String, password: String): AuthResult {
            return try {
                firebaseAuth.createUserWithEmailAndPassword(email, password).await()
                AuthResult.Success
            } catch (e: Exception) {
                AuthResult.Error(e.message ?: "Something went wrong")
            }
        }

    }

