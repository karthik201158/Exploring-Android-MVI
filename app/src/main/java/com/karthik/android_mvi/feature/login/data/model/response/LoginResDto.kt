package com.karthik.android_mvi.feature.login.data.model.response

data class LoginResDto(
    val id: String,
    val name: String,
    val email: String,
    val token: String,
    val message: String? = null
)