package com.example.shareableviewmodel;

import android.content.Intent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class sharedViewModel extends ViewModel {
    private MutableLiveData<CharSequence> text ;
    private MutableLiveData<Integer> progress ;
    private Repository repository;


    //this connect shareview model with reposetory
    public void init() {
        //repo is connected( instance is recived)
        repository=Repository.getInstance();
        text=repository.getText();
        progress=repository.getProgress();


    }

    public MutableLiveData<Integer> getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        repository.setprogres(progress);
    }


    public void setText(CharSequence input) {
        repository.settext(input);

    }
    public LiveData<CharSequence> getText() {
        return text;
    }

}
