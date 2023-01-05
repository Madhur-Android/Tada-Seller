package com.example.tadaseller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tadaseller.ApiServices.ApiService;
import com.example.tadaseller.AppModals.SellerLogin;
import com.example.tadaseller.Retrofits.RetrofitService;
import com.example.tadaseller.databinding.ActivityLogInBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class  LogInActivity extends AppCompatActivity {

    ActivityLogInBinding binding;
    TextView forgotPassword_TV, create_account_btn;
    EditText email_ET, password_ET;
    ApiService apiService;

    public void login(String email,String password) {

        apiService= RetrofitService.getRetrofit().create(ApiService.class);

        Call<SellerLogin> call=apiService.loginSeller(email,password);
        call.enqueue(new Callback<SellerLogin>() {
            @Override
            public void onResponse(Call<SellerLogin> call, Response<SellerLogin> response) {
                if(response.body ().getStatusCode () == 202) {
                    Log.i("Login Success Message",response.body().getMessage());
                    Intent i = new Intent (getApplicationContext (), MainActivity.class);
                    startActivity (i);
                    Toast.makeText (LogInActivity.this, "Welcome", Toast.LENGTH_SHORT).show ();
                    finish();
                }
                else
                {
                    Toast.makeText(LogInActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SellerLogin> call, Throwable t) {
                Toast.makeText(LogInActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLogInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        getSupportActionBar().hide();

        forgotPassword_TV = findViewById (R.id.forgotPassword_TV);
        email_ET = findViewById (R.id.email_ET);
        password_ET = findViewById (R.id.password_ET);
        create_account_btn = findViewById (R.id.create_account_btn);

        TextPaint paint = binding.tadaLogo.getPaint();
        float width = paint.measureText("Tada");
        Shader textShader = new LinearGradient(0, 0, width, binding.tadaLogo.getTextSize(),
                new int[]{
                        Color.parseColor("#FE0187"),
                        Color.parseColor("#FF5A3A"),
                }, null, Shader.TileMode.CLAMP);
        binding.tadaLogo.getPaint().setShader(textShader);

        binding.loginBtn.setOnClickListener (view -> {
            String email = email_ET.getText ().toString ();
            String password = password_ET.getText ().toString ();

            if (email.isEmpty ()) {
                email_ET.setError ("Please Enter Email");
                email_ET.requestFocus ();
            } else if (password.isEmpty ()) {
                password_ET.setError ("Enter Your Password");
                password_ET.requestFocus ();
            } else {

                    login(email,password);
            }
        });

        forgotPassword_TV.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (getApplicationContext (), ForgotPasswordActivity.class);
                startActivity (i);
            }
        });

        create_account_btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (getApplicationContext (), SignUpActivity.class);
                startActivity (i);
            }
        });
    }
}
