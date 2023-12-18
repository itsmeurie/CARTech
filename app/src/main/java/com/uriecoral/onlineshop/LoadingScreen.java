package com.uriecoral.onlineshop;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Timer;
import java.util.TimerTask;

public class LoadingScreen extends AppCompatActivity {
    LottieAnimationView avSecLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);

        // Check for internet connectivity
        if (isNetworkAvailable()) {
            prog();
        } else {
            // Display a toast message when there is no internet connection
            Toast.makeText(this, "No internet connection, please try again later", Toast.LENGTH_LONG).show();
            // Exit the app after showing the toast
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finishAffinity();
                }
            }, 1000); // Set the duration to 2000 milliseconds (2 seconds)
        }
    }

    private void prog() {
        avSecLoad = findViewById(R.raw.greenload);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(LoadingScreen.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

    // Check if the device has an active internet connection
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return false;
    }
}
