package com.example.service

import android.app.Service
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var myService: MyService? = null
    var isBound = false
    val myConnection = object : ServiceConnection{
        override fun onServiceDisconnected(className: ComponentName?) {
            isBound = false
        }
        override fun onServiceConnected(className: ComponentName?, service: IBinder?) {
            val binder = service as MyService.MyLocalBinder
            myService = binder.getService()
            isBound = true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, MyService::class.java)
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE)

        btnNumber.setOnClickListener {
            Log.i("service", "num: "+myService?.getMyNumber())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if(isBound) {
            unbindService(myConnection)
        }
    }
}
