package com.example.compaq.romansi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class listkonsulrealgi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listkonsulrealgi);
    }

    public void real(View view) {
        startActivity(new Intent(listkonsulrealgi.this,chatreal.class));
    }
}
