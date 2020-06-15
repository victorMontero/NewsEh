package com.android.newseh.modules.SignUp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.newseh.R;
import com.android.newseh.modules.Login.view.LoginActivity;
import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity {

    private TextInputEditText nameEditText;
    private TextInputEditText emailEditText;
    private TextInputEditText passwordEditText;
    private TextInputEditText confirmPasswordEditText;
    private Button okButton;
    private String emptyString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initializesFields();

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goesToLogin();
            }
        });




    }

    private void goesToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void initializesFields() {
        nameEditText = findViewById(R.id.name_edit_text_sign_up_activity);
        emailEditText = findViewById(R.id.email_edit_text_sign_up_activity);
        passwordEditText = findViewById(R.id.password_edit_text_sign_up_activity);
        confirmPasswordEditText = findViewById(R.id.confirm_password_edit_text_sign_up_activity);
        okButton = findViewById(R.id.btn_ok_sign_up_activity);
    }
}

