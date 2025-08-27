package com.karthik.android_mvi.feature.login.data.repository

import com.karthik.android_mvi.feature.login.data.model.request.LoginReqDto
import com.karthik.android_mvi.feature.login.data.model.response.LoginResDto
import com.karthik.android_mvi.feature.login.data.remote.LoginApiService
import com.karthik.android_mvi.feature.login.domain.repositroy.LoginRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val api: LoginApiService
) : LoginRepository {

    override suspend fun login(request: LoginReqDto): LoginResDto {
       // return api.login(request)
        // Simulate network delay
        delay(2000)
        // Return dummy success response
        return LoginResDto(
            id = "12345",
            name = "John Doe",
            email = request.username,
            token = "dummy_token_abc123",
            message = "Login successful"
        )
    }
}
