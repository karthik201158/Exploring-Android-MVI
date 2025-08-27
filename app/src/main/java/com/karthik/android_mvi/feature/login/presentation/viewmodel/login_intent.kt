package com.karthik.android_mvi.feature.login.presentation.viewmodel

sealed class LoginIntent {
    data class Submit(val email: String, val password: String) : LoginIntent()
    object Reset : LoginIntent()
}