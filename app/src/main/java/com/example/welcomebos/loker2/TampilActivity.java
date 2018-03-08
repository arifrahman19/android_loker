package com.example.welcomebos.loker2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TampilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("nama");
        String deskripsi = intent.getStringExtra("deskripsi");
        String jeniskelamin = intent.getStringExtra("jeniskelamin");


        TextView textViewNama = (TextView) findViewById(R.id.company_name);
        TextView textViewDesc = (TextView) findViewById(R.id.deskripsi_loker);
        TextView textViewJenisK = (TextView) findViewById(R.id.jenis_kelamin);


        textViewNama.setText(nama);
        textViewDesc.setText(deskripsi);
        textViewJenisK.setText(jeniskelamin);


    }
}
