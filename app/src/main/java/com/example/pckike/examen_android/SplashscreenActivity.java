package com.example.pckike.examen_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import android.widget.TextView;

/**
 * Created by PCkike on 15/06/2017.
 */

public class SplashscreenActivity extends AppCompatActivity {


    private TextView tvUnifranz;
    private Animation animacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.login_activity);
        setContentView(R.layout.splashscreenactivity);

        tvUnifranz = (TextView) findViewById(R.id.tvUnifranz);
        animacion = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacion);
        tvUnifranz.startAnimation(animacion);
        animacion.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        LoginActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
}

