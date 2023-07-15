package com.lega.atstaff.data.datasource.impl

import com.lega.atstaff.data.api.ApiLogin
import com.lega.atstaff.data.datasource.LoginDatasource
import com.lega.atstaff.data.response.UserResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginDatasourceImpl @Inject constructor(
 private val apiLogin: ApiLogin
): LoginDatasource {

    override fun logIng(user:String, password:String): Flow<UserResponse>  = flow {
        delay(2000)
        emit(apiLogin.logInUser(mapOf("username" to user, "password" to password )))
    }

    override fun getUserId(userId: Int): Flow<UserResponse> =flow {
        delay(2000)
        emit(apiLogin.getUserId(userId))
    }

    override fun registerPersonal(name:String, organization:String, nationality:String, email:String, user:String, password:String): Flow<String>  = flow {
        delay(2000)
        emit(apiLogin.registerPersonal(mapOf("name" to name, "organization" to organization, "nationality" to nationality, "email" to email, "username" to user, "password" to password )))
    }
}