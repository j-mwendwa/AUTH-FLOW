package com.example.kotlinauthflow.data.Model

data class User(
    val uid: String= "",
    val email: String= "",
    val displayName: String?= null,
    val photoUrl: String?= null

)