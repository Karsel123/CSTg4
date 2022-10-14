package com.example.cstg4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity2 extends AppCompatActivity {
    private EditText userid, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        getIntent();


        userid = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        Button button = findViewById(R.id.btn1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = userid.getText().toString();
                String pass = password.getText().toString();

                if (TextUtils.isEmpty(user)) {
                    Toast.makeText(LoginActivity2.this, "Please enter your Userid", Toast.LENGTH_LONG).show();
                    userid.setError("Userid not entered!!!");
                    userid.requestFocus();
                } else if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(LoginActivity2.this, "Please enter your Password", Toast.LENGTH_LONG).show();
                    password.setError("Password not entered!!!");
                    password.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(user).matches()) {
                    userid.setError("Invalid UserId");
                    userid.requestFocus();
                } else {
                    Intent i = new Intent(LoginActivity2.this, HomeActivity.class);
                    startActivity(i);
                }
            }
        });
        Button btn = findViewById(R.id.appCompatButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity2.this, RegisterStudentActivity.class);
                startActivity(intent);
            }
        });

    }

    private void registerUser(String user,String pass){
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(LoginActivity2.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity2.this, "Login Sucessfull", Toast.LENGTH_LONG).show();
                    FirebaseUser firebaseUser = auth.getCurrentUser();

                    firebaseUser.sendEmailVerification();
                    Intent i=new Intent(LoginActivity2.this,HomeActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);
                    finish();
                }
            }
               });



    }
}