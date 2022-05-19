package com.project.biblinarium.mvvm.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.viewModels.account.RegistrationViewModel;

public class RegistrationActivity extends AppCompatActivity {

    EditText newLoginEnter;
    EditText newPasswordEnter;
    EditText repeatPasswordEnter;
    EditText newNicknameEnter;
    Button doneRegistrationButton;

    RegistrationViewModel registrationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        newLoginEnter = (EditText) findViewById(R.id.editText_registration_setLogin);
        newPasswordEnter = (EditText) findViewById(R.id.editText_registration_setPassword);
        repeatPasswordEnter = (EditText) findViewById(R.id.editText_registration_repeatPassword);
        newNicknameEnter = (EditText) findViewById(R.id.editText_registration_setNickname);
        doneRegistrationButton = (Button) findViewById(R.id.button_registration_doneRegistration);

        registrationViewModel = new ViewModelProvider(this).get(RegistrationViewModel.class);

        registrationViewModel.getSuccess().observe(this, success -> {
            if (success) {
                Toast.makeText(this, "User was successfully registered!", Toast.LENGTH_LONG).show();
                finish();
            } else {
                Toast.makeText(this, "Incorrect input or user already exists", Toast.LENGTH_LONG).show();
            }
        });

        doneRegistrationButton.setOnClickListener(view -> {
            String login = newLoginEnter.getText().toString();
            String password = newPasswordEnter.getText().toString();
            String repeatPassword = repeatPasswordEnter.getText().toString();
            String nickname = newNicknameEnter.getText().toString();
            registrationViewModel.register(login, password, repeatPassword, nickname);
        });
    }
}