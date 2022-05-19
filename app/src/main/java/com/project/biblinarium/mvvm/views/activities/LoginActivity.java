package com.project.biblinarium.mvvm.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.repositories.AnnouncementsRepository;
import com.project.biblinarium.mvvm.repositories.UserRepository;
import com.project.biblinarium.mvvm.viewModels.account.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    EditText loginEnter;
    EditText passwordEnter;
    Button authorizeButton;
    Button registrationButton;

    LoginViewModel loginVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        UserRepository.init();
        if (AnnouncementsRepository.getAllAnnouncements().isEmpty()) {
            AnnouncementsRepository.init();
        }

        loginEnter = (EditText) findViewById(R.id.editText_authorization_enterLogin);
        passwordEnter = (EditText) findViewById(R.id.editText_authorization_enterPassword);
        authorizeButton = (Button) findViewById(R.id.button_authorization_logIn);
        registrationButton = (Button) findViewById(R.id.button_authorization_SingUp);

        loginVM = new ViewModelProvider(this).get(LoginViewModel.class);

        loginVM.getLogin().observe(this, login -> {
            loginEnter.setText(login);
        });

        loginVM.getPassword().observe(this, password -> {
            passwordEnter.setText(password);
        });

        loginVM.getAccess().observe(this, access -> {
            if (access) {
                startActivity(new Intent(this, MainActivity.class));
                Toast.makeText(this, "Welcome, " + loginVM.getUserNickname() + '!', Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "This user wasn't found!", Toast.LENGTH_LONG).show();
            }
        });

        authorizeButton.setOnClickListener(view -> {
            String login = loginEnter.getText().toString();
            String password = passwordEnter.getText().toString();
            loginVM.authorize(login, password);
        });

        registrationButton.setOnClickListener(view -> {
            startActivity(new Intent(this, RegistrationActivity.class));
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        loginEnter.setText("");
        passwordEnter.setText("");
    }
}