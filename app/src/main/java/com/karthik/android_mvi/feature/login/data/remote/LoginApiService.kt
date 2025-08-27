package com.karthik.android_mvi.feature.login.data.remote

import com.karthik.android_mvi.feature.login.data.model.request.LoginReqDto
import com.karthik.android_mvi.feature.login.data.model.response.LoginResDto
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApiService {
    @POST("auth/login")
    suspend fun login(@Body request: LoginReqDto): LoginResDto
}