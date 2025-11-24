package com.example.kotlinauthflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinauthflow.domain.AuthResult
import com.example.kotlinauthflow.presentation.AuthViewModel
import com.example.kotlinauthflow.ui.theme.KotlinAuthFlowTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val vm: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            KotlinAuthFlowTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val authState by vm.authState.observeAsState(AuthResult.Idle)

                    // Observe the authState from the ViewModel
                    when (authState) {
                        is AuthResult.Loading -> Text("Loading...", modifier = Modifier.padding(innerPadding))
                        is AuthResult.Success -> Text("Login Success", modifier = Modifier.padding(innerPadding))
                        is AuthResult.Error -> Text("Error: ${(authState as AuthResult.Error).message}", modifier = Modifier.padding(innerPadding))
                        is AuthResult.Idle -> Text("Please log in", modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }

        // Try any of them:
        vm.loginWithEmail("test@example.com", "123456")
        // vm.loginWithPhone("+254712345678")
        // vm.loginWithGoogle()
    }
}