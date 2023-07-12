package com.lega.atstaff.data.api

import com.lega.atstaff.data.response.PersonalResponse
import com.lega.atstaff.data.response.UserResponse
import retrofit2.http.*

interface ApiLogin {

    @FormUrlEncoded
    @POST("/login/intro/")
    //@POST("/aviationtechstaff/login/intro/")  //LOCALHOST
    suspend fun logInUser(
        @FieldMap params:Map<String, String>
    ): UserResponse

    @FormUrlEncoded
    @POST("/login/registre/")
    //@POST("/aviationtechstaff/login/registre/") //localhost
    suspend fun registerPersonal(
        @FieldMap params:Map<String, String>
    ):String

    @GET("/login/getUser/{id}")
    //@GET("/aviationtechstaff/login/getUser/{id}")  //localhost
    suspend fun getUserId(@Path("id")id:Int): UserResponse

}