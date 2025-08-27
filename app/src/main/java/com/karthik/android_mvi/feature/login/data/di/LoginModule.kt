package com.karthik.android_mvi.feature.login.data.di

import com.karthik.android_mvi.feature.login.data.remote.LoginApiService
import com.karthik.android_mvi.feature.login.data.repository.LoginRepositoryImpl
import com.karthik.android_mvi.feature.login.domain.repositroy.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
object LoginModule {

    @Provides
    @Singleton
    fun provideLoginApi(retrofit: Retrofit): LoginApiService =
        retrofit.create(LoginApiService::class.java)

    @Provides
    @Singleton
    fun provideLoginRepository(api: LoginApiService): LoginRepository =
        LoginRepositoryImpl(api)
}


