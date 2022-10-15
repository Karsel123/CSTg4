package com.example.cstg4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RegisterStudentActivity extends AppCompatActivity {

    //aklsdjflkasjdflksadjflksa;djflksdaf
    //asfklsajdfl;kasjdflk;ajsdlfkjsal;kfjl
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);

        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RegisterStudentActivity.this,"Registration successful",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(RegisterStudentActivity.this, LoginActivity2.class);
                startActivity(intent);
            }
        });
    }
}