package com.lega.atstaff.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Courses(val id: Int,
                  val name: String = "",
                  val country:String,
                  val type:String,
                  val date: String,
                  val validity: String,
                  val id_personal: Int): Parcelable
