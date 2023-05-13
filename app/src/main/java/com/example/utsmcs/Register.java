package com.example.utsmcs;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.utsmcs.Database.UserHelper;

public class Register extends AppCompatActivity {

    public boolean validate(){
        if(email.getText().toString().isEmpty() || password.getText().toString().isEmpty() || cpassword.getText().toString().isEmpty() || username.getText().toString().isEmpty()){
            return false;
        }
        return true;
    }

    Button createAcc, loginbtn;
    TextView email, username, password, cpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.emailSignUp);
        username = findViewById(R.id.usernameSignUp);
        password = findViewById(R.id.passwordSignUp);
        cpassword = findViewById(R.id.confirmPasswordSignUp);
        createAcc = findViewById(R.id.createAccBtn);
        loginbtn = findViewById(R.id.buttonSignUp);

        Intent backtoHome = new Intent(this,MainActivity.class);

        loginbtn.setOnClickListener(e->{
            startActivity(backtoHome);
        });


        createAcc.setOnClickListener(e->{

            //VALIDASI USER
            if(!validate()){
                Toast.makeText(this, "Please Fill All The Credentials",Toast.LENGTH_SHORT).show(); return;
            }
            else{
                if(!(email.getText().toString().endsWith(".com"))){
                    Toast.makeText(this, "Email has to end with '.com'",Toast.LENGTH_SHORT).show(); return;
                }
                else if( !(password.getText().toString().equals(cpassword.getText().toString())) ){
                    Toast.makeText(this,"Password has to match", Toast.LENGTH_SHORT).show(); return;
                }
                else if(password.getText().toString().length()<5){
                    Toast.makeText(this,"Password length has to be more than 5", Toast.LENGTH_SHORT).show(); return;
                }
            }

            UserHelper db = new UserHelper(this);
            if(!db.insertUser(username.getText().toString(), password.getText().toString(), email.getText().toString())){
                Toast.makeText(this,"email has to be unique",Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this,"account successfully registered",Toast.LENGTH_SHORT).show();
            startActivity(backtoHome);
        });

    }
}