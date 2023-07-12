package com.lega.atstaff.data.response

import com.google.gson.annotations.SerializedName

data class Visa(

    @field:SerializedName("id_visa")
    val id: Int? = null,

    @field:SerializedName("country")
    val country: String? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("validity")
    val date: String? = null,

    @field:SerializedName("id_personal")
    val id_personal: Int? = null
)

