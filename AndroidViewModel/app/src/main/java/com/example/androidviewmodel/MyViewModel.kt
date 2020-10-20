package com.example.androidviewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle

class MyViewModel(application: Application, private val handle: SavedStateHandle) :
    AndroidViewModel(application) {
    private val key = application.resources.getString(R.string.data_key)
    private val shpName = application.resources.getString(R.string.shp_name)

    init {
        if (!handle.contains(key)) {
            load()
        }
    }

    fun getNumber(): LiveData<Int> {
        return handle.getLiveData(key)
    }

    private fun load() {
        val shp = getApplication<Application>().getSharedPreferences(shpName, Context.MODE_PRIVATE)
        val x = shp.getInt(key, 0)
        handle.set(key, x)
    }

    fun save() {
        val shp = getApplication<Application>().getSharedPreferences(shpName, Context.MODE_PRIVATE)
        val editor = shp.edit()
        editor.putInt(key, getNumber().value!!)
        editor.apply()
    }

    fun add(x: Int) {
        handle.set(key, getNumber().value!! + x)
    }
}