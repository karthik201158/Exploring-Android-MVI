package com.karthik.android_mvi.feature.login.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.karthik.android_mvi.common.ui.composables.AppButton
import com.karthik.android_mvi.common.ui.composables.InputTextField
import com.karthik.android_mvi.feature.login.presentation.viewmodel.LoginIntent
import com.karthik.android_mvi.feature.login.presentation.viewmodel.LoginUiState
import com.karthik.android_mvi.feature.login.presentation.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
    onLoginSuccess: (String) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Email Input
            InputTextField(
                value = email,
                onValueChange = { email = it },
                label = "Email",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Password Input
            InputTextField(
                value = password,
                onValueChange = { password = it },
                label = "Password",
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Login Button
            AppButton(
                text = "Login",
                onClick = {
                    viewModel.handleIntent(LoginIntent.Submit(email, password))
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // UI State
            when (uiState) {
                is LoginUiState.Loading -> CircularProgressIndicator()

                is LoginUiState.Success -> {
                    val data = (uiState as LoginUiState.Success).data
                    Text(text = data.message ?: "Welcome ${data.name}")
                    // Trigger success callback
                    onLoginSuccess(data.token)
                }

                is LoginUiState.Error -> {
                    val error = (uiState as LoginUiState.Error).error
                    Text(
                        text = "Error: $error",
                        color = MaterialTheme.colorScheme.error
                    )
                }

                else -> {}
            }
        }
    }
}
