package com.lega.atstaff.core.di.data

import com.lega.atstaff.data.datasource.LoginDatasource
import com.lega.atstaff.data.datasource.PersonalDatasource
import com.lega.atstaff.data.datasource.impl.LoginDatasourceImpl
import com.lega.atstaff.data.datasource.impl.PersonalDatasourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DatasourcesModules {

    @Binds
    abstract fun bindingLoginDatasource(loginDatasourImpl: LoginDatasourceImpl): LoginDatasource

    @Binds
    abstract fun bindingPersonalDatasource(impl: PersonalDatasourceImpl): PersonalDatasource
}