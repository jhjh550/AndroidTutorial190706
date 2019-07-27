package com.example.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.util.*

class MyService : Service() {

    inner class MyLocalBinder: Binder(){
        fun getService(): MyService{
            return this@MyService
        }
    }

    private val myBinder = MyLocalBinder()
    override fun onBind(intent: Intent): IBinder {
        return myBinder
    }

    fun getMyNumber(): Int{
        val rand = Random()
        return rand.nextInt(10)
    }
}
