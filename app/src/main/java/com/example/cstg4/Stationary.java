package com.example.cstg4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Stationary extends AppCompatActivity {
ImageView img1,img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stationary);

        img1=findViewById(R.id.menu);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu=new PopupMenu(Stationary.this,img1);
                popupMenu.getMenuInflater().inflate(R.menu.mainmenu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(Stationary.this,"You Clicked"+menuItem.getTitle(),Toast.LENGTH_LONG).show();

                        if(menuItem.getItemId()==R.id.feed){
                            Intent ints=new Intent(Stationary.this, FeedbackActivity.class);
                            startActivity(ints);

                        }else{
                            Intent ints=new Intent(Stationary.this, Customer.class);
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
                Intent i=new Intent(Stationary.this,LoginActivity2.class);
                startActivity(i);
            }
        });

    }
}