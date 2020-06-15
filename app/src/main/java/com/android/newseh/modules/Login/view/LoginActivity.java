package com.android.newseh.modules.Login.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.newseh.R;
import com.android.newseh.activities.HomeActivity;
import com.android.newseh.activities.RecoverPasswordActivity;
import com.android.newseh.modules.SignUp.view.SignUpActivity;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText emailEditText;
    private TextInputEditText passwordEditText;
    private Button buttonOkLogin;
    private TextView forgotPasswordTextView;
    private TextView signUpTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        startsFields();

        buttonOkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logIn();
            }
        });

        forgotPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goesToRecoverPassword();
            }
        });

        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goesToSignUp();
            }
        });

    }

    private void goesToSignUp() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    private void goesToRecoverPassword() {
        Intent intent = new Intent(this, RecoverPasswordActivity.class);
        startActivity(intent);
    }

    private void logIn() {

        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        emailEditText.setError(null);
        passwordEditText.setError(null);

        if(email.equals("vite@gmail.com") && password.equals("123456")){
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        } else {
            emailEditText.setError("invalid email and/or password :(");
            passwordEditText.setError("invalid email and/or password :(");
        }

    }


    private void startsFields() {
        emailEditText = findViewById(R.id.email_login_edit_text);
        passwordEditText = findViewById(R.id.password_login_edit_text);
        buttonOkLogin = findViewById(R.id.btn_login);
        forgotPasswordTextView = findViewById(R.id.btn_forgot_pass);
        signUpTextView = findViewById(R.id.btn_sign_up);
    }
}