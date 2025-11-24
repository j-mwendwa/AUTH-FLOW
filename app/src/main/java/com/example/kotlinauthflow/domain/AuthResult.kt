package com.example.kotlinauthflow.domain

//Results after auth can be success,error or loading

sealed class AuthResult{
    object Idle:AuthResult()
    object Success:AuthResult()
    data class Error(val message:String):AuthResult()
    object Loading:AuthResult()
}