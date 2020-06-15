package com.android.newseh.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.newseh.R;
import com.android.newseh.modules.Login.view.LoginActivity;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class RecoverPasswordActivity extends AppCompatActivity {

    private Button buttonReset;
    private TextInputEditText userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password);
        initializesFields();

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendResetEmail(view);
            }
        });


    }

    private void sendResetEmail(View view) {
        userEmail.setError(null);
        if(userEmail.getEditableText().toString().equals(" ")){
            userEmail.setError("please enter email address");
        } else {
            Snackbar.make(view, "a link to reset your password has sent to " +
                            userEmail.getEditableText().toString(),
                    Snackbar.LENGTH_INDEFINITE)
                    .setAction("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            goesToLogin();
                        }
                    }).setActionTextColor(getResources().getColor(R.color.regularRed))
                    .show();
        }
    }

    private void goesToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void initializesFields() {
        buttonReset = findViewById(R.id.btn_recover_pass);
        userEmail = findViewById(R.id.edit_text_email_recover_activity);
    }
}