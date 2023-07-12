package com.lega.atstaff.core.di.data

import com.lega.atstaff.data.repository.LoginRespositoryImpl
import com.lega.atstaff.data.repository.PersonalRepositoryImpl
import com.lega.atstaff.domain.repository.LoginRespository
import com.lega.atstaff.domain.repository.PersonalRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModules {
    @Binds
    abstract fun bindinLoginRepository(impl: LoginRespositoryImpl): LoginRespository

    @Binds
    abstract fun bindinPersonalRepository(impl: PersonalRepositoryImpl): PersonalRepository
}