package com.example.kotlinauthflow.domain

/*Implementation for our interface our interface will be emmail,
phone and google login*/

interface AuthService{
    //Email Login

    suspend fun login  (email:String,password:String):Boolean

    //Phone Login
    suspend fun login (phone:String):Boolean

    //Google Login
    suspend fun login():Boolean

    fun logout()

}
//Overloading -> Multiple functions with same name but different parameters
//Phone,email and google have the same name but with different parameters.