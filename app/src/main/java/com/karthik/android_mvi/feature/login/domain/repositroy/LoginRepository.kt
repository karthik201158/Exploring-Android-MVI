package com.karthik.android_mvi.feature.login.domain.repositroy

import com.karthik.android_mvi.feature.login.data.model.request.LoginReqDto
import com.karthik.android_mvi.feature.login.data.model.response.LoginResDto

interface LoginRepository {
    suspend fun login(request: LoginReqDto): LoginResDto
}