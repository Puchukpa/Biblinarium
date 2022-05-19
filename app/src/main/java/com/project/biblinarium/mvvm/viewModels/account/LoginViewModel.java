package com.project.biblinarium.mvvm.viewModels.account;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.biblinarium.mvvm.repositories.UserRepository;

public class LoginViewModel extends ViewModel {

    private final MutableLiveData<String> login = new MutableLiveData<>();
    private final MutableLiveData<String> password = new MutableLiveData<>();
    private final MutableLiveData<Boolean> access = new MutableLiveData<>();

    public MutableLiveData<String> getLogin() {
        return login;
    }

    public MutableLiveData<String> getPassword() {
        return password;
    }
    
    public MutableLiveData<Boolean> getAccess() {
        return access;
    }

    public String getUserNickname() {
        return UserRepository.getCurrentUser().getNickname();
    }

    public void authorize (String login, String password) {
        this.access.setValue(UserRepository.setCurrentUser(login, password));
    }
}
