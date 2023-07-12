package com.lega.atstaff.core.di.data

import com.lega.atstaff.data.api.ApiLogin
import com.lega.atstaff.data.api.ApiPersonal
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun provideApiLogin(retrofit: Retrofit): ApiLogin {
        return retrofit.create(ApiLogin::class.java)
    }

    @Provides
    fun provideApiPersonal(retrofit: Retrofit): ApiPersonal{
        return retrofit.create(ApiPersonal::class.java)
    }

}