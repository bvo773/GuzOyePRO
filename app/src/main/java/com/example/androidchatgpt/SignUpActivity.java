package com.example.androidchatgpt;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;





public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button signupButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signupButton = findViewById(R.id.signupButton);

        mAuth = FirebaseAuth.getInstance();

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                registerUser(email,password);
            }
        });
    }

    private void registerUser(String email, String password) {
        Log.d("EmailPasswordValidation", email + " " + password);
        //Validate email and password, show error by toast message
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            Toast.makeText(SignUpActivity.this, "Empty Fields", Toast.LENGTH_SHORT).show();
        }
        else if (!InputValidation.isValidEmail(email)) {
            Toast.makeText(SignUpActivity.this, "Invalid email format", Toast.LENGTH_SHORT).show();
        } else if (!InputValidation.isValidPassword(password)) {
            Log.d("EmailPasswordValidation", "password hit");
            Toast.makeText(SignUpActivity.this, "Password should be at least 4 characters, a uppercase, a lowercase, a digit, and a special character", Toast.LENGTH_LONG).show();
        } else {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // Sign up is successful, update UI with the signed-in user's information
                        Toast.makeText(SignUpActivity.this, "Successful Signed Up", Toast.LENGTH_SHORT).show();
                        FirebaseUser user = mAuth.getCurrentUser();
                        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // If signs up fails, display a message to the user, use task.getException() to get details about the failure
                        Toast.makeText(SignUpActivity.this, "Failed to sign up user, please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

}
