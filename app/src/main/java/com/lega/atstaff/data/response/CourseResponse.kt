package com.lega.atstaff.data.response

import com.google.gson.annotations.SerializedName

data class CourseResponse(

    @SerializedName("totalCount")
    val totalCount: Int? = null,

    @SerializedName("results")
    val results: List<Course?>? = null
    )

