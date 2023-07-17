package com.example.fooddeliveryapp.Activity.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.fooddeliveryapp.Activity.MainActivity;
import com.example.fooddeliveryapp.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        startAnimation();
    }

    private void startAnimation() {
        LottieAnimationView lottie = findViewById(R.id.lottie_animation);
        TextView appName = findViewById(R.id.appName);
        lottie.animate().setDuration(3500).start();
        appName.animate().translationY(-1400).setDuration(3500).setStartDelay(0);
        new Handler().postDelayed(() -> {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                }, 3500
        );
    }
}