package com.lega.atstaff.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Licenses(val id: Int,
                   val entity: String,
                   val number: String,
                   val country:String,
                   val validity: String,
                   val id_personal: Int): Parcelable
