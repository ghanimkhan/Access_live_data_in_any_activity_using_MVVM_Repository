package com.example.shareableviewmodel;

import androidx.lifecycle.MutableLiveData;

public class Repository {
    private static final Repository instance=new Repository();
    private MutableLiveData<CharSequence> text;
    private MutableLiveData<Integer> progress;

    public static Repository getInstance() {
        return instance;
    }

    private Repository(){
        text=new MutableLiveData<>();
        text.setValue("");
        progress=new MutableLiveData<>();
        progress.setValue(5);
    }

    public MutableLiveData<CharSequence> getText() {
        return text;
    }


    public void settext(CharSequence input) {
        text.postValue(input);
    }


    //save data form vm in repo prgress
    public void setprogres(int percentage) {
        this.progress.setValue(percentage);

    }

    public MutableLiveData<Integer> getProgress() {
        return progress;
    }
}
