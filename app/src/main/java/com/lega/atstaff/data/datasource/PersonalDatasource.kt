package com.lega.atstaff.data.datasource

import com.lega.atstaff.data.response.*
import kotlinx.coroutines.flow.Flow

interface PersonalDatasource {
    fun getListPersonal(): Flow<PersonalResponse>
    fun getPersoanlId(userId:Int): Flow<Persona>
    fun deletePersonal(userId:Int): Flow<Persona>
    fun updatePersonal(id:String, name:String,dni:String,nationality:String,organization:String,position:String,twitter:String,facebook:String,linkedin:String,phone:String): Flow<String>

    /* Get Title - Course - Licnese - Visa*/

    fun getListTitle(userId:Int): Flow<TitleResponse>
    fun getListCourse(userId:Int): Flow<CourseResponse>
    fun getListLicense(userId:Int): Flow<LicenseResponse>
    fun getListVisa(userId:Int): Flow<VisaResponse>

}
