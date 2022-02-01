package com.example.bdtrunsport.ui.termsCons;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;

public class TermsConsViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public TermsConsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Terms and Condition fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}