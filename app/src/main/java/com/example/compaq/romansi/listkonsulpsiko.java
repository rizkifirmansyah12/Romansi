package com.example.compaq.romansi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class listkonsulpsiko extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listkonsulpsiko);
    }


    public void psiko1(View view) {
        startActivity(new Intent(listkonsulpsiko.this,chatpsiko.class));
    }
}
