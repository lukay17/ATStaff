package com.lega.atstaff.data.response

import com.google.gson.annotations.SerializedName

data class Persona (

    @field:SerializedName("id_personal")
    val id: Int? = null,

    @field:SerializedName("img")
    val img: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("dni")
    val dni: String? = null,

    @field:SerializedName("nationality")
    val nationality: String? = null,

    @field:SerializedName("organization")
    val organization: String? = null,

    @field:SerializedName("position")
    val position: String? = null,

    @field:SerializedName("facebook")
    val facebook: String? = null,

    @field:SerializedName("twitter")
    val twitter: String? = null,

    @field:SerializedName("linkedin")
    val linkedin: String? = null,

    @field:SerializedName("phone")
    val phone: String? = null
)