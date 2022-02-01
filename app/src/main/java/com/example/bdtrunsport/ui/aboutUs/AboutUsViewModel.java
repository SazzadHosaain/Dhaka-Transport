package com.example.bdtrunsport.ui.aboutUs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;

public class AboutUsViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public AboutUsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is About us fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}