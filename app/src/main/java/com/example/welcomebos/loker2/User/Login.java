package com.example.welcomebos.loker2.User;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.welcomebos.loker2.MainActivity;
import com.example.welcomebos.loker2.R;

public class Login extends AppCompatActivity {

    //Inisialisasi
    EditText editTextemail, editTextpassword;
    String emailLogin, passwordLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Button untuk register
        Button btn1 = (Button) findViewById(R.id.btnLinkToRegisterScreen);
        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent i = new Intent(getApplicationContext(), Register.class);
                startActivity(i);
            }
        });

    }

    //Method untuk login
    public void loginMasuk(View view){
        //Method onclick pada button

        editTextemail = (EditText) findViewById(R.id.email);
        editTextpassword = (EditText) findViewById(R.id.password);
        emailLogin = editTextemail.getText().toString();
        passwordLogin = editTextpassword.getText().toString();

        //Konidisi jika email dan pass benar maka akan menampilkan pesan toast dan masuk ke mainactivity
        if ((emailLogin.contains("ali@gmail.com"))&&((passwordLogin.contains("ali")))){
            Toast.makeText(this, "Login Sukses", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        }

        //Atau jika email dan password kosong
        else if ((emailLogin.matches("")||passwordLogin.matches(""))){
            Toast.makeText(this, "Isikan Email dan Password", Toast.LENGTH_LONG).show();
        }

        //Jika kedua kondisi diatas tidak memenuhi
        else {
            Toast.makeText(this, "Email dan Password salah", Toast.LENGTH_LONG).show();
        }
    }

}
