package com.lega.atstaff.data.mappers

import com.lega.atstaff.data.response.Persona
import com.lega.atstaff.data.response.UserResponse
import com.lega.atstaff.domain.models.Personal
import com.lega.atstaff.domain.models.User


fun UserResponse.mapToUser() = User(
    user = this.user ?: "",
    password = this.password?:"",
    email = this.email ?: "sin email",
    role = this.role ?: -1,
    id_personal = this.id_personal ?: -1,
    img = this.img?:""
)




