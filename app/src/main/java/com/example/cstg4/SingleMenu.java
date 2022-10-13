package com.example.cstg4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SingleMenu extends AppCompatActivity {
    ImageView img;//hi
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_menu);
        getIntent();

        img=findViewById(R.id.imageView);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intss=new Intent(SingleMenu.this, CanteenOwnerActivity.class);
                startActivity(intss);
            }
        });
    }
}