package com.lega.atstaff.data.datasource

import com.lega.atstaff.data.response.Persona
import com.lega.atstaff.data.response.UserResponse
import kotlinx.coroutines.flow.Flow

interface LoginDatasource {
    fun logIng(user: String, pass: String): Flow<UserResponse>
    fun getUserId(userId:Int): Flow<UserResponse>
    fun registerPersonal(name: String, organization: String, nationality: String, email: String, user: String, pass: String): Flow<String>
}