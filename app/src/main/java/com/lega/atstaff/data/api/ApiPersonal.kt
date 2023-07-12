package com.lega.atstaff.data.api

import com.lega.atstaff.data.response.*
import retrofit2.http.*

interface ApiPersonal {

    @GET("/personal/control/list")
    //@GET("/aviationtechstaff/personal/control/list")  //localhost
    suspend fun getListPersonal(): PersonalResponse

    @GET("/personal/control/views/{id}")
    //@GET("/aviationtechstaff/personal/control/views/{id}")  //localhost
    suspend fun getPersonalId(@Path("id")id:Int): Persona

    @POST("/personal/control/delet/{id}")
    //@POST("/aviationtechstaff/personal/control/delet/{id}")  //localhost
    suspend fun deletePersonal(@Path("id")id:Int):Persona

    @GET("/personal/control/titles/{id}")
    //@GET("/aviationtechstaff/personal/control/titles/{id}")  //localhost
    suspend fun getListTitles(@Path("id")id:Int): TitleResponse

    @GET("/personal/control/courses/{id}")
    //@GET("/aviationtechstaff/personal/control/courses/{id}")  //localhost
    suspend fun getListCourses(@Path("id")id:Int): CourseResponse

    @GET("/personal/control/licenses/{id}")
    //@GET("/aviationtechstaff/personal/control/licenses/{id}")  //localhost
    suspend fun getListLicenses(@Path("id")id:Int): LicenseResponse

    @GET("/personal/control/visas/{id}")
    //@GET("/aviationtechstaff/personal/control/visas/{id}")  //localhost
    suspend fun getListVisas(@Path("id")id:Int): VisaResponse

    @FormUrlEncoded
    @POST("personal/control/updatee/")
    //@POST("/aviationtechstaff/login/registre/") //localhost
    suspend fun updatePersonal(
        @FieldMap params:Map<String, String>
    ):String
}
