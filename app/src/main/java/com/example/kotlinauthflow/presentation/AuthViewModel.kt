package com.example.kotlinauthflow.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinauthflow.data.repository.DefaultAuthRepository
import com.example.kotlinauthflow.domain.AuthRepository
import com.example.kotlinauthflow.domain.AuthResult
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class AuthViewModel @Inject constructor(private val repo: AuthRepository) : ViewModel() {
    private val _authState =
        MutableStateFlow<AuthResult>(AuthResult.Idle) //Mutable ,not visible to the user
    val authState = _authState.asStateFlow()//Visible in the compose screen

    // Login

    fun login(email: String, password: String) {
        _authState.value = AuthResult.Loading
        viewModelScope.launch {
            val result = repo.login(email, password)
            _authState.value = result
        }

        fun register(email: String, password: String) {
            _authState.value = AuthResult.Loading
            viewModelScope.launch {

                val result = repo.register(email, password)
                _authState.value = result
            }

        }

    }

}