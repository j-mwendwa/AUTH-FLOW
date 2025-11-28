package com.example.kotlinauthflow.data.repository

import com.example.kotlinauthflow.domain.AuthRepository
import com.example.kotlinauthflow.domain.AuthService
import com.example.kotlinauthflow.domain.FacebookAuthService
import com.example.kotlinauthflow.domain.GoogleAuthService
import com.example.kotlinauthflow.domain.TwitterAuthService
import jakarta.inject.Inject

class DefaultAuthRepository @Inject constructor(private val service: AuthService,private val googleAuthService: GoogleAuthService,
    private val facebookAuthService: FacebookAuthService,private val twitterAuthService: TwitterAuthService

): AuthRepository {

    override suspend fun login(email: String, password: String) =
        service.login(email, password)

    // override suspend fun loginWithPhone(phone: String) =


    override suspend fun register(email: String, password: String) =
        service.register(email, password)


    //override suspend fun loginWithGoogle(idToken: String) = service.loginWithGoogle(idToken)

    override suspend fun googleLogin(idToken: String) = googleAuthService.firebaseAuthWithGoogle(idToken)

    override suspend fun facebookLogin(accessToken: String) = facebookAuthService.facebookLogin(accessToken)

    override suspend fun twitterLogin(accessToken: String, accessSecret: String) = twitterAuthService.twitterLogin(accessToken, accessSecret)


}



    //override fun logout() {
    // service.logout()
    //}
