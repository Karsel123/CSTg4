package com.example.cstg4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class First extends AppCompatActivity {
    CardView btn1,btn2,btn3,btn4;
    ImageView img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        img2=findViewById(R.id.profile);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(First.this,LoginActivity2.class);
                startActivity(i);
            }
        });


        getIntent();

        btn1=findViewById(R.id.sec);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ints=new Intent(First.this, SingleMenu.class);
                startActivity(ints);


            }
        });
        btn2=findViewById(R.id.drink);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ints=new Intent(First.this, DrinkMenu.class);
                startActivity(ints);
            }
        });

        btn3=findViewById(R.id.stationary);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ints=new Intent(First.this, Stationary.class);
                startActivity(ints);
            }
        });

        btn4=findViewById(R.id.grocery);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ints=new Intent(First.this, Grocery.class);
                startActivity(ints);
            }
        });
    }
}