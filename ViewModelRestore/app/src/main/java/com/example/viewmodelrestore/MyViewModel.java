package com.example.viewmodelrestore;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private SavedStateHandle handle;
    private final static String KEY_NUMBER = "MY_NUMBER";

    public MyViewModel(SavedStateHandle handle) {
        if (!handle.contains(KEY_NUMBER)) {
            handle.set(KEY_NUMBER, 0);
        }
        this.handle = handle;
    }

    public MutableLiveData<Integer> getNumber() {

        return handle.getLiveData(KEY_NUMBER);
    }

    public void add() {
        handle.set(KEY_NUMBER, (int) handle.get(KEY_NUMBER) + 1);
    }

}
