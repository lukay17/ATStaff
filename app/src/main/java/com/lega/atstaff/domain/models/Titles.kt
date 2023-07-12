package com.lega.atstaff.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Titles(val id: Int,
                 val name: String = "",
                 val country:String,
                 val university:String,
                 val date: String,
                 val id_personal: Int): Parcelable
