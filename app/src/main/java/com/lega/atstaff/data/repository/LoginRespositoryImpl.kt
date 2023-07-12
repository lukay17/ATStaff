package com.lega.atstaff.data.repository

import com.lega.atstaff.data.datasource.LoginDatasource
import com.lega.atstaff.data.mappers.mapToUser
import com.lega.atstaff.data.mappers.matToPersonalId
import com.lega.atstaff.domain.models.Personal
import com.lega.atstaff.domain.models.User
import com.lega.atstaff.domain.repository.LoginRespository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LoginRespositoryImpl @Inject constructor(
    private val loginDatasource: LoginDatasource
) : LoginRespository {

    override fun logIn(username: String, password: String): Flow<User> =
        loginDatasource.logIng(username, password).map { it.mapToUser() }

    override fun getUserId(userId: Int): Flow<User> =
        loginDatasource.getUserId(userId).map { it.mapToUser()}

    override fun registerPersonal(
        name: String,
        organization: String,
        nationality: String,
        email: String,
        userName: String,
        password: String
    ): Flow<String> =
        loginDatasource.registerPersonal(name, organization, nationality, email, userName, password).map { it.toString() }
}