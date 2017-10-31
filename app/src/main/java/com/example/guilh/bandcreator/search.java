package com.example.guilh.bandcreator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class search extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String[] instruments={"piano", "guitarra"};
    int symbols[] = {R.drawable.classic_music, R.drawable.guitar};
    String[] styles = {"classic", "rock", "jazz", "blues", "punk"};
    int styles_icons[] = {R.drawable.classic_music, R.drawable.classic_music, R.drawable.classic_music,R.drawable.classic_music, R.drawable.classic_music};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_for);

         Spinner spin = (Spinner) findViewById(R.id.simpleSpinner);
            spin.setOnItemSelectedListener(this);
        CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),symbols,instruments);
        spin.setAdapter(customAdapter);

            Spinner spin2 = (Spinner) findViewById(R.id.simpleSpinner2);
            CustomAdapter customAdapter2=new CustomAdapter(getApplicationContext(),styles_icons, styles);
            spin2.setAdapter(customAdapter2);
        }


        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }
    }
