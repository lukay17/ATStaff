package com.lega.atstaff.domain.repository

import com.lega.atstaff.domain.models.*
import kotlinx.coroutines.flow.Flow

interface PersonalRepository {
    fun getListPersonal(): Flow<List<Personal>>
    fun getPersoanlId(userId:Int): Flow<Personal>
    fun deletePersonal(userId:Int): Flow<Personal>
    fun updatePersonal(id:String, name:String,dni:String,nationality:String,organization:String,position:String,twitter:String,facebook:String,linkedin:String,phone:String): Flow<String>

    /* Get Title - Course - Licnese - Visa*/
    fun getListTitle(userId: Int): Flow<List<Titles>>
    fun getListLicense(userId: Int): Flow<List<Licenses>>
    fun getListCourse(userId: Int): Flow<List<Courses>>
    fun getListVisa(userId: Int): Flow<List<Visas>>
}