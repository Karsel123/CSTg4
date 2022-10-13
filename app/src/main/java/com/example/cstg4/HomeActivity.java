package com.example.cstg4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    CardView btn1,btn2,btn3,btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getIntent();

        btn1=findViewById(R.id.sec);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ints=new Intent(HomeActivity.this, SingleMenu.class);
                startActivity(ints);


            }
        });
        btn2=findViewById(R.id.drink);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ints=new Intent(HomeActivity.this, SingleMenu.class);
                startActivity(ints);
            }
        });

        btn3=findViewById(R.id.stationary);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ints=new Intent(HomeActivity.this, SingleMenu.class);
                startActivity(ints);
            }
        });

        btn4=findViewById(R.id.grocery);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ints=new Intent(HomeActivity.this, SingleMenu.class);
                startActivity(ints);
            }
        });
    }
}