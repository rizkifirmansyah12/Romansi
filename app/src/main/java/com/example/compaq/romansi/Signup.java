package com.example.compaq.romansi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Signup extends AppCompatActivity {

    ProgressDialog pDialog;
    Button btnsignup;
    EditText etNamauser,etNamadepan,etNamabelakang,etpasswordsign,etEmail,etTTL,etTanggalPernikahan,etNomerTelp;
    RadioButton radioButton,radioButton2;
    Intent intent;

    int success;
    ConnectivityManager conMgr;

    private String url = Server.URL + "register.php";

    private static final String TAG = Signup.class.getSimpleName();

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    String tag_json_obj = "json_obj_req";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

    }
}
