package com.example.kotlinauthflow.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinauthflow.data.repository.DefaultAuthRepository
import com.example.kotlinauthflow.domain.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch



sealed class AuthResult{
    object Idle:AuthResult()
    object Success:AuthResult()
    data class Error(val message:String):AuthResult()
    object Loading:AuthResult()
}
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
            _authState.value = if (result.isSuccess) AuthResult.Success else AuthResult.Error(
                result.exceptionOrNull()?.message ?: "Error Encountered"
            )
        }

        fun GoogleLogin(idToken: String) {
            _authState.value = AuthResult.Loading
            viewModelScope.launch {
                val result = repo.googleLogin(idToken)
                _authState.value = if (result.isSuccess) AuthResult.Success else AuthResult.Error(

                    result.exceptionOrNull()?.message ?: "Google Login Failed"
                )
            }

        }
        fun FacebookLogin(accessToken: String) {
            _authState.value = AuthResult.Loading
            viewModelScope.launch {
                val result = repo.facebookLogin(accessToken)
                _authState.value = if (result.isSuccess) AuthResult.Success else AuthResult.Error(

                    result.exceptionOrNull()?.message ?: "Facebook Login Failed"
                )

            }
        }


        fun register(email: String, password: String) {
            _authState.value = AuthResult.Loading
            viewModelScope.launch {

                val result = repo.register(email, password)
                _authState.value = if (result.isSuccess) AuthResult.Success else AuthResult.Error(
                    result.exceptionOrNull()?.message ?: "Error Encountered"
                )
            }
            }

        }

    }
