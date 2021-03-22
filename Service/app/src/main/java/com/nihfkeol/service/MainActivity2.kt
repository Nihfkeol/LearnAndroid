package com.nihfkeol.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        button.setOnClickListener {
            val bindIntent = Intent(this, MyService::class.java)
            val serviceConnection = object : ServiceConnection{
                override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                    (service as MyService.MyBinder).service.numberLiveData.observe(this@MainActivity2, {
                        textView2.text = "$it"
                    })
                }

                override fun onServiceDisconnected(name: ComponentName?) {
                    TODO("Not yet implemented")
                }

            }
            bindService(bindIntent,serviceConnection, Context.BIND_AUTO_CREATE)
        }
    }
}