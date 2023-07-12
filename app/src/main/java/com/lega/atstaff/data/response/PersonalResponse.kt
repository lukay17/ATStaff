package com.lega.atstaff.data.response

import com.google.gson.annotations.SerializedName

data class PersonalResponse(

    @SerializedName("totalCount")
    val totalCount: Int? = null,

    @SerializedName("results")
    val results: List<Persona?>? = null
    )

