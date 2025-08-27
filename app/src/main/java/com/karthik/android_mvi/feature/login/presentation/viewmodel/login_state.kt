package com.karthik.android_mvi.feature.login.presentation.viewmodel

import com.karthik.android_mvi.feature.login.data.model.response.LoginResDto

sealed class LoginUiState {
    object Initial : LoginUiState()
    object Loading : LoginUiState()
    data class Success(val data: LoginResDto) : LoginUiState()
    data class Error(val error: String) : LoginUiState()
}