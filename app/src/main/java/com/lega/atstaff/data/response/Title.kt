package com.lega.atstaff.data.response

import com.google.gson.annotations.SerializedName

data class Title(

    @field:SerializedName("id_title")
    val id: Int? = null,

    @field:SerializedName("title")
    val name: String? = null,

    @field:SerializedName("country")
    val country: String? = null,

    @field:SerializedName("university")
    val university: String? = null,

    @field:SerializedName("date")
    val date: String? = null,

    @field:SerializedName("id_personal")
    val id_personal: Int? = null
)

