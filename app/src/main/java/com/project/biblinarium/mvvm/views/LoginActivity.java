package com.project.biblinarium.mvvm.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.viewModels.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    TextView loginEnter;
    TextView passwordEnter;
    Button authorizeButton;

    LoginViewModel loginVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginVM = new ViewModelProvider(this).get(LoginViewModel.class);



    }
}