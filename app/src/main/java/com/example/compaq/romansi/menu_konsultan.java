package com.example.compaq.romansi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class menu_konsultan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_konsultan);
    }

    public void psiko(View view) {
        startActivity(new Intent(menu_konsultan.this,listkonsulpsiko.class));
    }

    public void sekso(View view) {
        startActivity(new Intent(menu_konsultan.this,listkonsulsekso.class));
    }

    public void reali(View view) {
        startActivity(new Intent(menu_konsultan.this,listkonsulrealgi.class));
    }
}
