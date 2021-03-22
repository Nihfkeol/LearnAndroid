package com.nihfkeol.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    //记录服务是否被绑定
    private var flagServiceConn = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: ")

        val bindIntent = Intent(this, MyService::class.java)
        val serviceConnection = object : ServiceConnection{
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                (service as MyService.MyBinder).service.numberLiveData.observe(this@MainActivity,
                    {
                        textView.text = "$it"
                    })
            }

            override fun onServiceDisconnected(name: ComponentName?) {
                TODO("Not yet implemented")
            }

        }

        buttonBindService.setOnClickListener {
            //如果想要点击返回退出应用后，服务还在后台继续运行，则需先启动服务再绑定
            startService(bindIntent)
            //BIND_AUTO_CREATE 不存在则自动创建
            flagServiceConn = bindService(bindIntent, serviceConnection, Context.BIND_AUTO_CREATE)
        }

        buttonStopService.setOnClickListener {
            if (flagServiceConn){
                //unbindService()传入的conn参数不能为null，也就是必须有绑定存在，才能解绑
                unbindService(serviceConnection)
                flagServiceConn = false
            }
            stopService(bindIntent)
        }

        buttonStartToActivity.setOnClickListener {
            Intent(this, MainActivity2::class.java).also {
                startActivity(it)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }
}