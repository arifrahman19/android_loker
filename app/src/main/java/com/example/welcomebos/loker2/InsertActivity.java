package com.example.welcomebos.loker2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.welcomebos.loker2.API.RegisterAPI;
import com.example.welcomebos.loker2.Model.Value;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InsertActivity extends AppCompatActivity {


    public static final String URL = "http://192.168.43.100:8080/db_lokerandroidfix/";
//    public static final String URL = "http://192.168.0.5:8080/db_lokerandroidfix/";
    private RadioButton radioSexButton;
    private ProgressDialog progress;

    @BindView(R.id.radioSesi) RadioGroup radioGroup;
    @BindView(R.id.editTextID) EditText editTextID;
    @BindView(R.id.editTextNamaPerusahaan) EditText editTextNamaPerusahaan;
    @BindView(R.id.editTextDeskripsi) EditText editTextDeskripsi;

    @OnClick(R.id.buttonDaftar) void daftar() {

        //membuat progress dialog
        progress = new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();

        //mengambil data dari edittext
        String npm = editTextID.getText().toString();
        String nama = editTextNamaPerusahaan.getText().toString();
        String deskripsi = editTextDeskripsi.getText().toString();

        int selectedId = radioGroup.getCheckedRadioButtonId();
        // mencari id radio button
        radioSexButton = (RadioButton) findViewById(selectedId);
        String jeniskelamin = radioSexButton.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<Value> call = api.daftar(npm, nama, deskripsi, jeniskelamin);
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                String message = response.body().getMessage();
                progress.dismiss();
                if (value.equals("1")) {
                    Toast.makeText(InsertActivity.this, message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(InsertActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(InsertActivity.this, "Jaringan Error!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    //Ketika klik button lihat data
//    @OnClick(R.id.buttonLihat) void lihat() {
//        startActivity(new Intent(MainActivity.this, ViewActivity.class));
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        ButterKnife.bind(this);
    }

}
