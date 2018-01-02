package com.example.compaq.romansi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class listkonsulsekso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listkonsulsekso);
    }

    public void sekso(View view) {
        startActivity(new Intent(listkonsulsekso.this,chatsekso.class));
    }
}
