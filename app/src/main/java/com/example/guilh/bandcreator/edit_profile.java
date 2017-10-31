package com.example.guilh.bandcreator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class edit_profile extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);
    }
    @Override
    public void onBackPressed() {
        return;
    }
}
