package com.example.kuyybertani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kuyybertani.login.LoginActivty;

public class splasActivty extends AppCompatActivity {

    private ImageView ho;
    private TextView logo;
    private TextView slogan;

    private Animation atas;
    private Animation bawah;
    private static int SPLASH_TIME = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splas_activty);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ho = findViewById(R.id.ho);
        logo = findViewById(R.id.hi);
        slogan = findViewById(R.id.textView2);

        atas = AnimationUtils.loadAnimation(this, R.anim.atas);
        bawah = AnimationUtils.loadAnimation(this, R.anim.bawah);

        ho.setAnimation(atas);
        logo.setAnimation(bawah);
        slogan.setAnimation(bawah);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent mySuperIntent = new Intent(splasActivty.this, LoginActivty.class);
                startActivity(mySuperIntent);

                finish();
            }
        }, SPLASH_TIME);
    }
}
