package com.project.biblinarium.mvvm.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SearchingLineViewModel extends ViewModel {

    private final MutableLiveData<String> searchRequest = new MutableLiveData<>();

    public MutableLiveData<String> getSearchRequest() {
        return searchRequest;
    }
}
