package com.miniprojet.miniprojet;

import android.app.ProgressDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    EditText mEmailEt, mPasswordEt;
    Button mRegisterBtn;
    ProgressDialog progressDialog;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // action et its titre
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("create Account");
        // enable back button
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //init
        mEmailEt = findViewById(R.id.emailEt);
        mPasswordEt = findViewById(R.id.passwordEt);
        mRegisterBtn = findViewById(R.id.registerBtn);
        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Register user...");


        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //input email ,password
                String email =mEmailEt.getText().toString().trim();
                String password =mPasswordEt.getText().toString().trim();

                //valide
                if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    //set error and focuss
                    mEmailEt.setError("Invalid Email");
                    mEmailEt.setFocusable(true);

                } else if (password.length() < 6) {
                    mPasswordEt.setError("Password length at least 6 characters ");
                    mPasswordEt.setFocusable(true);
                } else {
                    registerUser(email, password); // register the user

                }

            }
        });


    }

    private void registerUser(String email, String password) {
        progressDialog.show();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            FirebaseUser user =mAuth.getCurrentUser();
                            progressDialog.dismiss();
                            Toast.makeText(RegisterActivity.this,"Registred..\n"+user.getEmail(),Toast.LENGTH_LONG).show();
                            startActivity(new Intent(RegisterActivity.this,ProfilActivity.class));
                            finish();

                        } else {
                            progressDialog.dismiss();
                            Toast.makeText(RegisterActivity.this,"Authentication failed .",Toast.LENGTH_LONG).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull  Exception e) {
                progressDialog.dismiss();
                Toast.makeText(RegisterActivity.this,""+e.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }

    public boolean onSupportNavigateUp() {
        onBackPressed(); // go previous activity
        return super.onSupportNavigateUp();
    }
}