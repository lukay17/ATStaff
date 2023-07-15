package com.lega.atstaff.data.mappers

import com.lega.atstaff.data.response.*
import com.lega.atstaff.domain.models.Personal
import com.lega.atstaff.domain.models.*


fun PersonalResponse.matToPersonal() =
    results?.map {
        Personal(
            id = it?.id ?: 0,
            img = it?.img?.split("?")?.get(0)?:"",
            name = it?.name ?:"",
            dni = it?.dni ?:"",
            nationality = it?.nationality  ?: "",
            organization = it?.organization ?:"",
            position = it?.position ?: "",
            twitter = it?.twitter ?:"",
            facebook = it?.facebook ?:"",
            linkedin = it?.linkedin ?:"",
            phone = it?.phone ?:""
        )
    }.orEmpty()

fun Persona.matToPersonalId() = Personal(
    id = this.id ?: -1,
    img =this.img ?: "",
    name = this?.name ?:"",
    dni = this?.dni?:"",
    nationality = this?.nationality ?:"",
    organization = this?.organization?: "",
    position = this?.position ?:"",
    twitter = this?.twitter ?:"",
    facebook = this?.facebook ?:"",
    linkedin = this?.linkedin ?:"",
    phone = this?.phone ?:""
)

fun TitleResponse.mapToTitles() =
    results?.map {
            Titles(
                id = it?.id ?: 0,
                name = it?.name ?:"",
                country = it?.country ?:"",
                university = it?.university  ?: "",
                date = it?.date ?:"",
                id_personal = it?.id_personal ?: -1
            )
    }

fun CourseResponse.mapToCourses() =
    results?.map {
        Courses(
            id = it?.id ?: 0,
            name = it?.name ?:"",
            country = it?.country ?:"",
            type = it?.type  ?: "",
            date = it?.date ?:"",
            validity = it?.validity?:"",
            id_personal = it?.id_personal ?: -1
        )
    }

fun LicenseResponse.mapToLicenses() =
    results?.map {
        Licenses(
            id = it?.id ?: 0,
            entity = it?.entity ?:"",
            country = it?.country ?:"",
            number = it?.number  ?: "",
            validity = it?.date ?:"",
            id_personal = it?.id_personal ?: -1
        )
    }

fun VisaResponse.mapToVisas() =
    results?.map {
        Visas(
            id = it?.id ?: 0,
            country = it?.country ?:"",
            type = it?.type?:"",
            date = it?.date  ?: "",
            id_personal = it?.id_personal ?: -1
        )
    }



