package com.example.bdtrunsport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class UniversityBus2 extends AppCompatActivity {
    LinearLayout diuBus,bupBus,ulabBus,juBus,uiuBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_bus2);

        diuBus = findViewById(R.id.diuBus);
        bupBus = findViewById(R.id.bupBus);
        ulabBus = findViewById(R.id.ulabBus);
        juBus = findViewById(R.id.juBus);
        uiuBus = findViewById(R.id.uiuBus);


        diuBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), com.example.bdtrunsport.Diu_Bus.class));
            }
        });

        ulabBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), com.example.bdtrunsport.ULAB_Bus2.class));
            }
        });
        juBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), com.example.bdtrunsport.JU_Bus2.class));
            }
        });

        bupBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),BupBus.class));
            }
        });
        uiuBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Coming Soon!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}