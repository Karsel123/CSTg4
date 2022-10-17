package com.example.cstg4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterStudentActivity extends AppCompatActivity {

    //aklsdjflkasjdflksadjflksa;djflksdaf
    //asfklsajdfl;kasjdflk;ajsdlfkjsal;kfjl
    Button btn;
    private FirebaseAuth firebaseAuth;
    private EditText editTextTextPersonName, regisEmail, regisPass;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);

        getIntent();

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

    private void signUpUser() {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(regisEmail.getText().toString(), regisPass.getText().toString())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        progressDialog.dismiss();
                        Toast.makeText(RegisterStudentActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),  LoginActivity2.class));
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(RegisterStudentActivity.this, e.getMessage() + "", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}