package com.lega.atstaff.domain.repository

import com.lega.atstaff.domain.models.Personal
import com.lega.atstaff.domain.models.User
import kotlinx.coroutines.flow.Flow

interface LoginRespository {
    fun logIn(userName:String, password:String): Flow<User>
    fun getUserId(userId:Int): Flow<User>
    fun registerPersonal(name:String, organization:String, nationality:String, email:String, userName:String, password:String): Flow<String>
}