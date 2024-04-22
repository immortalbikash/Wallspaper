package com.example.wallspaper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

//    private Button login;
//    private EditText email, password;
//    private TextView newAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//        email = findViewById(R.id.etEmail);
//        password = findViewById(R.id.etRPassword);
//        login = findViewById(R.id.btnLogin);
//        newAccount = findViewById(R.id.tvNewAccount);
//
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (!validateEmail() | !validatePassword()) {
//                } else {
//                    checkUser();
//                }
//
//            }
//        });
//
//        newAccount.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
//                startActivity(intent);
//                MainActivity.this.finish();
//            }
//        });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

//    public Boolean validateEmail() {
//        String val = email.getText().toString();
//        if (val.isEmpty()) {
//            email.setError("Username cannot be empty");
//            return false;
//        } else {
//            email.setError(null);
//            return true;
//        }
//    }
//
//    public boolean validatePassword(){
//        String val = password.getText().toString();
//        if(val.isEmpty()){
//            password.setError("Password cannot be empty");
//            return false;
//        }
//        else{
//            password.setError(null);
//            return true;
//        }
//    }
//
//    public void checkUser(){
//        String userEmail = email.getText().toString().trim();
//        String userPassword = password.getText().toString().trim();
//
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
//        Query checkUserDatabase = reference.orderByChild("email").equalTo(userEmail);
//
//        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(snapshot.exists()){
//                    email.setError(null);
//                    String passwordFromDB = snapshot.child(userEmail).child("password").getValue(String.class);
//
//                    if(passwordFromDB.equals(userPassword)){
//                        email.setError(null);
//                        Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
//                        startActivity(intent);
//                    }
//                    else{
//                        password.setError("Invalid credentials");
//                        password.requestFocus();
//                    }
//                }
//                else{
//                    email.setError("User does not exist");
//                    email.requestFocus();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
    }