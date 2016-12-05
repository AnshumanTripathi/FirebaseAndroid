package com.loginapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText emailEditTxt;
    private Button forgotPasswordBtn;

    private static final String TAG = "ForgotPasswordActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailEditTxt = (EditText) findViewById(R.id.userEmail);

        forgotPasswordBtn = (Button) findViewById(R.id.forgotPassword);

        forgotPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditTxt.getText().toString();
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "Email sent!");
                                    Toast.makeText(ForgotPasswordActivity.this,
                                            R.string.resetPasswordConfirm,
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent
                                            (ForgotPasswordActivity.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            }
                        });
            }
        });

    }
}
