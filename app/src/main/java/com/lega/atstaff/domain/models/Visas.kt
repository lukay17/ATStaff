package com.lega.atstaff.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Visas(val id: Int,
                val type: String = "",
                val country:String,
                val date: String,
                val id_personal: Int): Parcelable
