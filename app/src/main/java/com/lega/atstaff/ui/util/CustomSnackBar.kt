package com.lega.atstaff.ui.util

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.snackbar.Snackbar
import com.lega.atstaff.R

class CustomSnackBar {

    var PRIMARY = 1

    var SUCCESS = 2

    var WARNING = 3

    var DANGER = 4

    var INFO = 5

    var DEFAULT = 6

    fun Primary(view: View, text: String){
        //Snackbar(view)
       val snackbar = Snackbar.make(view, text, Snackbar.LENGTH_LONG)
           .setTextColor(Color.WHITE)
           .setBackgroundTint(Color.parseColor("#0d6efd"))
           .setActionTextColor(Color.MAGENTA)
       val snackBarView = snackbar.view

        val tv = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        tv.textSize = 18f
        val font = ResourcesCompat.getFont(view.context, R.font.akaya_telivigala)
        tv.setTypeface(font)
        snackbar.show()
    }

    fun Secondary(view: View, text: String){
        //Snackbar(view)
        val snackbar = Snackbar.make(view, text, Snackbar.LENGTH_LONG)
            .setTextColor(Color.WHITE)
            .setBackgroundTint(Color.parseColor("#6c757d"))
            .setActionTextColor(Color.MAGENTA)
        val snackBarView = snackbar.view

        val tv = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        tv.textSize = 18f
        val font = ResourcesCompat.getFont(view.context, R.font.akaya_telivigala)
        tv.setTypeface(font)
        snackbar.show()
    }

    fun Success(view: View, text: String){
        //Snackbar(view)
        val snackbar = Snackbar.make(view, text, Snackbar.LENGTH_LONG)
            .setTextColor(Color.WHITE)
            .setBackgroundTint(Color.parseColor("#198754"))
            .setActionTextColor(Color.MAGENTA)
        val snackBarView = snackbar.view

        val tv = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        tv.textSize = 18f
        val font = ResourcesCompat.getFont(view.context, R.font.akaya_telivigala)
        tv.setTypeface(font)
        snackbar.show()
    }

    fun Danger(view: View, text: String){
        //Snackbar(view)
        val snackbar = Snackbar.make(view, text, Snackbar.LENGTH_LONG)
            .setTextColor(Color.WHITE)
            .setBackgroundTint(Color.parseColor("#dc3545"))
            .setActionTextColor(Color.MAGENTA)
        val snackBarView = snackbar.view

        val tv = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        tv.textSize = 18f
        val font = ResourcesCompat.getFont(view.context, R.font.akaya_telivigala)
        tv.setTypeface(font)
        snackbar.show()
    }

    fun Warning(view: View, text: String){
        //Snackbar(view)
        val snackbar = Snackbar.make(view, text, Snackbar.LENGTH_LONG)
            .setTextColor(Color.WHITE)
            .setBackgroundTint(Color.parseColor("#ffc107"))
            .setActionTextColor(Color.MAGENTA)
        val snackBarView = snackbar.view

        val tv = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        tv.textSize = 18f
        val font = ResourcesCompat.getFont(view.context, R.font.akaya_telivigala)
        tv.setTypeface(font)
        snackbar.show()
    }

    fun Info(view: View, text: String){
        //Snackbar(view)
        val snackbar = Snackbar.make(view, text, Snackbar.LENGTH_LONG)
            .setTextColor(Color.WHITE)
            .setBackgroundTint(Color.parseColor("#0dcaf0"))
            .setActionTextColor(Color.MAGENTA)
        val snackBarView = snackbar.view

        val tv = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        tv.textSize = 18f
        val font = ResourcesCompat.getFont(view.context, R.font.akaya_telivigala)
        tv.setTypeface(font)
        snackbar.show()
    }

    fun Dark(view: View, text: String){
        //Snackbar(view)
        val snackbar = Snackbar.make(view, text, Snackbar.LENGTH_LONG)
            .setTextColor(Color.WHITE)
            .setBackgroundTint(Color.parseColor("#212529"))
            .setActionTextColor(Color.MAGENTA)
        val snackBarView = snackbar.view

        val tv = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        tv.textSize = 18f
        tv.setTextColor(Color.WHITE)
        val font = ResourcesCompat.getFont(view.context, R.font.akaya_telivigala)
        tv.setTypeface(font)
        snackbar.show()
    }

    fun Light(view: View, text: String){
        //Snackbar(view)
        val snackbar = Snackbar.make(view, text, Snackbar.LENGTH_LONG)
            .setTextColor(Color.WHITE)
            .setBackgroundTint(Color.parseColor("#f8f9fa"))
            .setActionTextColor(Color.MAGENTA)
        val snackBarView = snackbar.view

        val tv = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        tv.textSize = 18f
        val font = ResourcesCompat.getFont(view.context, R.font.akaya_telivigala)
        tv.setTypeface(font)
        snackbar.show()
    }

    fun Custom(view: View, text: String, txtColor :Int, backColor:Int){
        //Snackbar(view)
        val snackbar = Snackbar.make(view, text, Snackbar.LENGTH_LONG)
            .setTextColor(txtColor)
            .setBackgroundTint(Color.parseColor("#f8f9fa"))
            .setActionTextColor(backColor)
        val snackBarView = snackbar.view

        val tv = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        tv.textSize = 18f
        val font = ResourcesCompat.getFont(view.context, R.font.akaya_telivigala)
        tv.setTypeface(font)
        snackbar.show()
    }

    fun Image(view: View, text: String, type:Int){
        //Snackbar(view)
        val snackbar = Snackbar.make(view, text, Snackbar.LENGTH_LONG)
            .setTextColor(Color.WHITE)
            .setActionTextColor(Color.MAGENTA)
        val snackBarView = snackbar.view
        val tv = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        tv.gravity = Gravity.CENTER
        tv.textSize = 18f
        val font = ResourcesCompat.getFont(view.context, R.font.akaya_telivigala)
        tv.setTypeface(font)

        if(type == PRIMARY){
            snackbar.setBackgroundTint(Color.parseColor("#0d6efd"))
            tv.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_info,0)
        }
        if(type == SUCCESS){
            snackbar.setBackgroundTint(Color.parseColor("#198754"))
            tv.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_success,0)
        }
        if(type == WARNING){
            snackbar.setBackgroundTint(Color.parseColor("#ffc107"))
            tv.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_warning,0)
        }
        if(type == DANGER){
            snackbar.setBackgroundTint(Color.parseColor("#dc3545"))
            tv.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_dangerous,0)
        }
        if(type == INFO){
            snackbar.setBackgroundTint(Color.parseColor("#0dcaf0"))
            tv.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_info,0)
        }
        if(type == DEFAULT){
            snackbar.setBackgroundTint(Color.parseColor("#6c757d"))
            tv.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_info,0)
        }

        snackbar.show()
    }
}


