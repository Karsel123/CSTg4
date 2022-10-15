package com.example.cstg4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    CardView btn1,btn2,btn3,btn4;
    ImageView img1,img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        img1=findViewById(R.id.menu);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu=new PopupMenu(HomeActivity.this,img1);
                popupMenu.getMenuInflater().inflate(R.menu.mainmenu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(HomeActivity.this,"You Clicked"+menuItem.getTitle(),Toast.LENGTH_LONG).show();

                        if(menuItem.getItemId()==R.id.feed){
                            Intent ints=new Intent(HomeActivity.this, FeedbackActivity.class);
                            startActivity(ints);

                        }else{
                            Intent ints=new Intent(HomeActivity.this, Customer.class);
                            startActivity(ints);
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
        img2=findViewById(R.id.profile);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent i=new Intent(HomeActivity.this,LoginActivity2.class);
              startActivity(i);
            }
        });


        getIntent();

        btn1=findViewById(R.id.sec);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent ints=new Intent(HomeActivity.this, Grocery.class);
                startActivity(ints);


            }
        });
        btn2=findViewById(R.id.drink);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ints=new Intent(HomeActivity.this, DrinkMenu.class);
                startActivity(ints);
            }
        });

        btn3=findViewById(R.id.stationary);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ints=new Intent(HomeActivity.this, Stationary.class);
                startActivity(ints);
            }
        });

        btn4=findViewById(R.id.grocery);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ints=new Intent(HomeActivity.this, Grocery.class);
                startActivity(ints);
            }
        });
    }
}