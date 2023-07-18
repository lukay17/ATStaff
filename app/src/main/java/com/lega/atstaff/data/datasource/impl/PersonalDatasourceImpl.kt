package com.lega.atstaff.data.datasource.impl

import com.lega.atstaff.data.api.ApiPersonal
import com.lega.atstaff.data.datasource.PersonalDatasource
import com.lega.atstaff.data.response.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PersonalDatasourceImpl @Inject constructor(
    private val apiPersonal: ApiPersonal
): PersonalDatasource {

    override fun getListPersonal(): Flow<PersonalResponse> = flow {
        emit(apiPersonal.getListPersonal())
    }

    override fun getPersoanlId(userId: Int): Flow<Persona> =flow {
        emit(apiPersonal.getPersonalId(userId))
    }

    override fun deletePersonal(userId: Int): Flow<Persona> = flow {
        emit(apiPersonal.deletePersonal(userId))
    }

    override fun updatePersonal(id: String, name: String,  dni: String, nationality: String,  organization: String, position: String, twitter: String, facebook: String, linkedin: String, phone: String): Flow<String> = flow {
        emit(apiPersonal.updatePersonal(mapOf("id" to id,"name" to name, "dni" to dni, "nationality" to nationality, "organization" to organization,  "position" to position, "twitter" to twitter, "facebook" to facebook, "linkedin" to linkedin, "phone"  to phone )))
    }

    /*override fun registerPersonal(name:String, organization:String, nationality:String, email:String, user:String, password:String): Flow<String>  = flow {
        emit(apiLogin.registerPersonal(mapOf("name" to name, "organization" to organization, "nationality" to nationality, "email" to email, "username" to user, "password" to password )))
    }
     */
    override fun getListTitle(userId: Int): Flow<TitleResponse> = flow {
        emit(apiPersonal.getListTitles(userId))
    }

    override fun getListCourse(userId: Int): Flow<CourseResponse> = flow {
        emit(apiPersonal.getListCourses(userId))
    }

    override fun getListLicense(userId: Int): Flow<LicenseResponse> = flow {
        emit(apiPersonal.getListLicenses(userId))
    }

    override fun getListVisa(userId: Int): Flow<VisaResponse> = flow {
        emit(apiPersonal.getListVisas(userId))
    }
}