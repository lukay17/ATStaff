package com.lega.atstaff.data.repository

import com.lega.atstaff.data.datasource.PersonalDatasource
import com.lega.atstaff.data.mappers.*
import com.lega.atstaff.domain.models.*
import com.lega.atstaff.domain.repository.PersonalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PersonalRepositoryImpl @Inject constructor(
    private val datasource: PersonalDatasource,
) : PersonalRepository {

    override fun getListPersonal(): Flow<List<Personal>> {
        return datasource.getListPersonal()
            .map {
                it.matToPersonal()
            }
    }

    override fun getPersoanlId(userId: Int): Flow<Personal> =
        datasource.getPersoanlId(userId).map { it.matToPersonalId()}

    override fun deletePersonal(userId: Int): Flow<Personal> =
       datasource.deletePersonal(userId).map { it.matToPersonalId()}

    override fun updatePersonal(
        id: String,
        name: String,
        dni: String,
        nationality: String,
        organization: String,
        position: String,
        twitter: String,
        facebook: String,
        linkedin: String,
        phone: String,
    ): Flow<String> =
        datasource.updatePersonal(id, name, dni, nationality, organization, position, twitter, facebook, linkedin, phone).map { it.toString() }

    override fun getListTitle(userId: Int): Flow<List<Titles>> {
        return datasource.getListTitle(userId)
            .map {
                it.mapToTitles()!!
            }
    }

    override fun getListLicense(userId: Int): Flow<List<Licenses>> {
        return datasource.getListLicense(userId)
            .map {
                it.mapToLicenses()!!
            }
    }

    override fun getListCourse(userId: Int): Flow<List<Courses>> {
        return datasource.getListCourse(userId)
            .map {
                it.mapToCourses()!!
            }
    }

    override fun getListVisa(userId: Int): Flow<List<Visas>> {
        return datasource.getListVisa(userId)
            .map {
                it.mapToVisas()!!
            }
    }
}