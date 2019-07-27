package com.example.service

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder

class MainActivity : AppCompatActivity() {

    var myService: MyService? = null
    val myConnection = object : ServiceConnection{
        override fun onServiceDisconnected(className: ComponentName?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
        override fun onServiceConnected(className: ComponentName?, service: IBinder?) {
            val binder = service as MyService.MyLocalBinder
            myService = binder.getService()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, MyService::class.java)
        bindService(intent, )
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService()
    }
}
