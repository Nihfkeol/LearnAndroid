package com.example.livedatatest;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelWithLiveData extends ViewModel {
    private MutableLiveData<Integer> likeNumber;

    public MutableLiveData<Integer> getLiveData() {
        if (likeNumber == null){
            likeNumber = new MutableLiveData<>();
            likeNumber.setValue(0);
        }
        return likeNumber;
    }

    public void addLikeNumber(int n){
        likeNumber.setValue(likeNumber.getValue() + n);
    }

}
