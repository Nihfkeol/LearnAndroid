package com.example.viewmodelshp;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

public class MyViewModel extends AndroidViewModel {
    private SavedStateHandle handle;
    private String MUMBER_KEY = getApplication().getResources().getString(R.string.NUMBER_KEY);
    private String SHP_NAME = getApplication().getResources().getString(R.string.SHP_NAME);

    public MyViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        this.handle = handle;
        if (!handle.contains(MUMBER_KEY)){
            load();
        }
    }

    private void load() {
        SharedPreferences shp = getApplication().getSharedPreferences(SHP_NAME, Context.MODE_PRIVATE);
        int x = shp.getInt(MUMBER_KEY, getApplication().getResources().getInteger(R.integer.defValue));
        handle.set(MUMBER_KEY, x);
    }

    public void save(){
        SharedPreferences shp = getApplication().getSharedPreferences(SHP_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putInt(MUMBER_KEY, getNumber().getValue());
        editor.apply();
    }

    public MutableLiveData<Integer> getNumber(){
        return handle.getLiveData(MUMBER_KEY);
    }

    public void add(int x){
        handle.set(MUMBER_KEY, getNumber().getValue() + x);
    }

}
