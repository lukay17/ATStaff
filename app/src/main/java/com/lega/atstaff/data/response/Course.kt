package com.lega.atstaff.data.response

import com.google.gson.annotations.SerializedName

data class Course(

    @field:SerializedName("id_training")
    val id: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("country")
    val country: String? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("date")
    val date: String? = null,

    @field:SerializedName("validity")
    val validity: String? = null,

    @field:SerializedName("id_personal")
    val id_personal: Int? = null
)

