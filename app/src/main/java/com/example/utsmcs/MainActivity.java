package com.example.utsmcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.utsmcs.Database.UserHelper;
import com.example.utsmcs.Model.User;

public class MainActivity extends AppCompatActivity {

    Button btnLogin, signUp;
    TextView email, password;

    public boolean validate(){
        if(email.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
            return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean cek=false;
        UserHelper uh = new UserHelper(this);

        btnLogin = findViewById(R.id.buttonLogin);
        signUp = findViewById(R.id.buttonSignUp);
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        Intent gotohome = new Intent(this,Home.class);
        Intent regist = new Intent(this, Register.class);


        //VALIDASI USER
        btnLogin.setOnClickListener(e->{

            if(!validate()){
                Toast.makeText(this,"Please fill all credentials",Toast.LENGTH_SHORT).show();
                return;
            }

            Integer curId = 0;
            UserHelper db = new UserHelper(this);
            curId = db.cekUser(email.getText().toString(),password.getText().toString());
            if(curId<0){
                Toast.makeText(this,"Invalid password or email",Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this,"Login Successful",Toast.LENGTH_SHORT).show();
            gotohome.putExtra("userId",curId); //PASSING DATA SATU
            startActivity(gotohome);
        });

        signUp.setOnClickListener(e->{
            startActivity(regist);
        });




    }
}