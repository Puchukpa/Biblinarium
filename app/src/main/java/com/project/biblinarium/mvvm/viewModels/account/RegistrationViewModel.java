package com.project.biblinarium.mvvm.viewModels.account;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.biblinarium.mvvm.repositories.UserRepository;

public class RegistrationViewModel extends ViewModel {

    private MutableLiveData<Boolean> success = new MutableLiveData<>();

    public MutableLiveData<Boolean> getSuccess() {
        return success;
    }

    public void register(String login, String password, String repeatPassword, String nickname) {
        if (!password.equals(repeatPassword)) {
            success.setValue(false);
            return;
        }

        success.setValue(UserRepository.addNewUser(login, password, nickname));
    }
}
