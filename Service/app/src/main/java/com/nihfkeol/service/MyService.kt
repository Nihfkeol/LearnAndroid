package com.nihfkeol.service

import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyService : LifecycleService() {

    val numberLiveData = MutableLiveData(0)
    private val TAG = "MyService"

    inner class MyBinder:Binder(){
        val service = this@MyService
    }

    override fun onBind(intent: Intent): IBinder {
        super.onBind(intent)
        Log.d(TAG, "onBind: Service")
        lifecycleScope.launch {
            while (true){
                delay(1_000)
                numberLiveData.value = numberLiveData.value?.plus(1)
                Log.d(TAG, "onBind: ${numberLiveData.value}")
            }
        }
        return MyBinder()
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: Service")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand: Service")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Service")
    }
}