package com.example.wallspaper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private EditText first_name, last_name, register_email, register_password;
    private Button register;
    private TextView already_account;

    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        //binding
        first_name = findViewById(R.id.etFname);
        last_name = findViewById(R.id.etLname);
        register_email = findViewById(R.id.Remail);
        register_password = findViewById(R.id.etRPassword);
        register = findViewById(R.id.btnRegister);
        already_account = findViewById(R.id.tvAlreadyAccount);

        //for register
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");

                //fetching data from form
                String fname = first_name.getText().toString();
                String lname = last_name.getText().toString();
                String email = register_email.getText().toString();
                String password = register_password.getText().toString();

                if(fname.length()==0){
                    first_name.requestFocus();
                    first_name.setError("Field cannot be empty");
                }

                else if(lname.length()==0){
                    last_name.requestFocus();
                    last_name.setError("Field cannot be empty");
                }

                else if(email.length()==0){
                    register_email.requestFocus();
                    register_email.setError("Field cannot be empty");
                }

                else if(password.length()==0){
                    register_password.requestFocus();
                    register_password.setError("Field cannot be empty");
                }
                else{
                    HelperClass helperClass = new HelperClass(fname, lname, email, password);
                    reference.child(email).setValue(helperClass);

                    Toast.makeText(RegisterActivity.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        already_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}