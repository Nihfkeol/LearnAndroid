package com.example.score;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> FractionA;
    private MutableLiveData<Integer> FractionB;

    private int aBack, bBack;

    public MutableLiveData<Integer> getFractionA() {
        if (FractionA == null) {
            FractionA = new MutableLiveData<>();
            FractionA.setValue(0);
        }
        return FractionA;
    }

    public MutableLiveData<Integer> getFractionB() {
        if (FractionB == null) {
            FractionB = new MutableLiveData<>();
            FractionB.setValue(0);
        }
        return FractionB;
    }

    public void aTeamAdd(int p) {
        aBack = FractionA.getValue();
        bBack = FractionB.getValue();
        FractionA.setValue(FractionA.getValue() + p);
    }

    public void bTeamAdd(int p) {
        aBack = FractionA.getValue();
        bBack = FractionB.getValue();
        FractionB.setValue(FractionB.getValue() + p);
    }


    public void reset() {
        aBack = FractionA.getValue();
        bBack = FractionB.getValue();
        FractionA.setValue(0);
        FractionB.setValue(0);
    }

    public void undo() {
        FractionA.setValue(aBack);
        FractionB.setValue(bBack);
    }
}
