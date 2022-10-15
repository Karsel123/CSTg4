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

public class RegsiterStaffActivity extends AppCompatActivity {
    private Button btn;
    private FirebaseAuth firebaseAuth;
    private EditText editTextTextPersonName, regisEmail, regisPass;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regsiter_staff);

        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        regisEmail = findViewById(R.id.regisEmail);
        regisPass = findViewById(R.id.regisPass);

        btn=findViewById(R.id.reg_Id);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog = new ProgressDialog(RegsiterStaffActivity.this);
                progressDialog.setMessage("Registering...");
                progressDialog.show();
                signUpUser();
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
                        Toast.makeText(RegsiterStaffActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),  LoginActivity2.class));
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(RegsiterStaffActivity.this, e.getMessage() + "", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}