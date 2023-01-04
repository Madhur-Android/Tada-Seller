package com.example.tadaseller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tadaseller.ApiServices.ApiService;
import com.example.tadaseller.AppModals.SellerForgotPassword;
import com.example.tadaseller.Retrofits.RetrofitService;
import com.example.tadaseller.databinding.ActivityForgotPasswordBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPasswordActivity extends AppCompatActivity {


    ActivityForgotPasswordBinding binding;
    EditText email_ET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        binding = ActivityForgotPasswordBinding.inflate (getLayoutInflater ());
        setContentView (binding.getRoot ());

        email_ET = findViewById (R.id.email_ET);

        binding.resetpwBtn.setOnClickListener (view -> {
            String email = email_ET.getText ().toString ();

            if (email.isEmpty () || email.contains ("@") || email.contains (".")) {
                email_ET.setError ("Please Enter Email");
                email_ET.requestFocus ();
            } else {
                forgot (email);
            }
        });
    }

    public void forgot(String email) {
        ApiService apiService = RetrofitService.getRetrofit ().create (ApiService.class);
        Call<SellerForgotPassword> call = apiService.forgotSeller (email);
        call.enqueue (new Callback<SellerForgotPassword> () {
            @Override
            public void onResponse(@NonNull Call<SellerForgotPassword> call, @NonNull Response<SellerForgotPassword> response) {
                assert response.body () != null;
                if (response.body ().getStatus_code () == 200) {
                    Log.i ("Forgot Password Success", response.body ().getMessage ());
                    Intent i = new Intent (getApplicationContext (), LogInActivity.class);
                    startActivity (i);
                    Toast.makeText (ForgotPasswordActivity.this, "Check Your Mail...", Toast.LENGTH_SHORT).show ();
                    finish ();
                } else {
                    Toast.makeText (ForgotPasswordActivity.this, response.body ().getMessage (), Toast.LENGTH_SHORT).show ();
                }
            }

            @Override
            public void onFailure(Call<SellerForgotPassword> call, Throwable t) {
                Toast.makeText (ForgotPasswordActivity.this, t.getMessage (), Toast.LENGTH_SHORT).show ();

            }
        });
    }
}
