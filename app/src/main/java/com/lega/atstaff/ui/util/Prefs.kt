package com.lega.atstaff.ui.util

import android.content.Context

class Prefs(val context:Context) {

    val SHARED_NAME = "access"
    val SHARED_USER_NAME = "username"
    val SHARED_USER_ID = "id"
    val SHARED_VIP = "vip"
    val storage = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)

    fun saveId(id:Int){
        storage.edit().putInt(SHARED_USER_ID, id).commit()
    }

    fun saveName(name:String){
        storage.edit().putString(SHARED_USER_NAME, name).commit()
    }

    fun saveVIP(vip: Boolean){
        storage.edit().putBoolean(SHARED_VIP, vip).commit()
    }

    fun getId():Int{
        return storage.getInt(SHARED_USER_ID,-1)
    }

    fun getName():String{
        return storage.getString(SHARED_USER_NAME, "")!!
    }

    fun getVIP():Boolean{
        return  storage.getBoolean(SHARED_VIP, false)
    }

    fun wipeUser(){
        storage.edit().clear().commit()
    }
}