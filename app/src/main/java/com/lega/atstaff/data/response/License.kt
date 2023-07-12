package com.lega.atstaff.data.response

import com.google.gson.annotations.SerializedName

data class License(

    @field:SerializedName("id_license")
    val id: Int? = null,

    @field:SerializedName("number")
    val number: String? = null,

    @field:SerializedName("country")
    val country: String? = null,

    @field:SerializedName("entity")
    val entity: String? = null,

    @field:SerializedName("validity")
    val date: String? = null,

    @field:SerializedName("id_personal")
    val id_personal: Int? = null
)

