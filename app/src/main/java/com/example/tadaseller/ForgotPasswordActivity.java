package com.example.tadaseller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tadaseller.databinding.ActivityForgotPasswordBinding;

public class ForgotPasswordActivity extends AppCompatActivity {


    ActivityForgotPasswordBinding binding;
    EditText email_ET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        email_ET = findViewById (R.id.email_ET);

        binding.resetpwBtn.setOnClickListener (view -> {
            String Email = email_ET.getText ().toString ();

            if (Email.isEmpty ()) {
                email_ET.setError ("Please Enter Email");
                email_ET.requestFocus ();
            } else {
                Toast.makeText (this, "Password Send On Email", Toast.LENGTH_SHORT).show ();
                Intent i = new Intent (getApplicationContext (), LogInActivity.class);
                startActivity (i);
            }
        });
    }
}
