package com.example.kotlinauthflow.data.services


import com.example.kotlinauthflow.domain.AuthService
import com.google.firebase.auth.FirebaseAuth
import jakarta.inject.Inject
import kotlinx.coroutines.tasks.await

class EmailAuthService @Inject constructor(private val firebaseAuth: FirebaseAuth) : AuthService {

    override suspend fun login(email: String, password: String): Result<Unit> {
       return try {
            firebaseAuth.signInWithEmailAndPassword(email, password).await()
           Result.success(Unit)
        } catch (e: Exception) {
           Result.failure(e)
           }
        }
        override suspend fun register(email: String, password: String): Result<Unit> {
            return try {
                firebaseAuth.createUserWithEmailAndPassword(email, password).await()
                Result.success(Unit)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }

    }

