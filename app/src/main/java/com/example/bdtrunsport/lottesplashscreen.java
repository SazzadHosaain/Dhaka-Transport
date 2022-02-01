package com.example.bdtrunsport;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class lottesplashscreen extends AppCompatActivity {

    Animation topAnim,bottomAnim;
    ImageView image;
    TextView text,text2;

    private  static  int Splash_timeout = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_lottesplashscreen);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this,R.anim.anim1);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.anim2);

        //Hooks
        image = findViewById(R.id.image);
        text = findViewById(R.id.text);
        text2 = findViewById(R.id.text2);

        image.setAnimation(topAnim);
        text.setAnimation(bottomAnim);
        text2.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(lottesplashscreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },Splash_timeout);

    }
}