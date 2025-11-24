package com.example.kotlinauthflow.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinauthflow.data.repository.DefaultAuthRepository
import com.example.kotlinauthflow.domain.AuthRepository
import com.example.kotlinauthflow.domain.AuthResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel (private val repo: AuthRepository) : ViewModel(){
    private val _authState = MutableStateFlow<AuthResult>(AuthResult.Idle)
    val authState = _authState.asStateFlow()

    //Phone Login
    fun loginWithPhone(phone: String){
        _authState.value = AuthResult.Loading
        viewModelScope.launch {
            _authState.value = repo.loginWithPhone(phone)
        }
    }

    //Email Login
    fun loginWithEmail(email: String, password: String){
        _authState.value = AuthResult.Loading
        viewModelScope.launch {
            _authState.value = repo.loginWithEmail(email, password)
        }
    }

    //GoogleLogin
    fun loginWithGoogle(){
        _authState.value = AuthResult.Loading
        viewModelScope.launch {
            _authState.value = repo.loginWithGoogle()
        }
    }
        fun logout() {
            repo.logout()
        }


}