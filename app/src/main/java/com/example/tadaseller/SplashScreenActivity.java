package com.example.tadaseller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextPaint;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import com.example.tadaseller.databinding.ActivitySplashScreenBinding;

public class SplashScreenActivity extends AppCompatActivity {

    ActivitySplashScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        TextPaint paint = binding.tadaLogo.getPaint();
        float width = paint.measureText("Tada");
        Shader textShader = new LinearGradient(0, 0, width, binding.tadaLogo.getTextSize(),
                new int[]{
                        Color.parseColor("#FE0187"),
                        Color.parseColor("#FF5A3A"),
                }, null, Shader.TileMode.CLAMP);
        binding.tadaLogo.getPaint().setShader(textShader);

        binding.goButton.setEnabled(false);
        RotateAnimation rotate = new RotateAnimation(360, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(2500);
        rotate.setInterpolator(new LinearInterpolator());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            binding.progressBar.setMin(10);
        }
        binding.progressBar.setMax(250);
        binding.goButton.startAnimation(rotate);

        Handler handler=new Handler();
        handler.postDelayed(() -> {
            binding.goButton.setEnabled(true);
            binding.progressBar.setAlpha(0);
        },2500);

        binding.goButton.setOnClickListener(view -> {
            Intent i=new Intent(getApplicationContext(),SignUpActivity.class);
            startActivity(i);
            finish();
        });
    }
}