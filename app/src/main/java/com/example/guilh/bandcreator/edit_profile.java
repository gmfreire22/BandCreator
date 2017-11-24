package com.example.guilh.bandcreator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class edit_profile extends AppCompatActivity{
    ImageView man_select, woman_select, done;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);
        man_select = (ImageView) findViewById(R.id.man_button);
        woman_select = (ImageView) findViewById(R.id.woman_button);
        done = (ImageView) findViewById(R.id.done);
        intent = new Intent(this, search.class);
        man_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                man_select.setColorFilter(0xFF0000FF);
                woman_select.setColorFilter(0);
                Log.i("Clicked", "Man was selected");
            }
        });
        woman_select.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                man_select.setColorFilter(0);
                woman_select.setColorFilter(Color.rgb(255, 0,255));
                Log.i("Clicked", "Woman was selected");

            }
        });
        done.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        return;
    }
}
