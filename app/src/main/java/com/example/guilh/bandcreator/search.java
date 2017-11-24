package com.example.guilh.bandcreator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

public class search extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String[] instruments={"piano", "guitarra"};
    ImageView go_to_search_button;
    ListView listView;
    int symbols[] = {R.drawable.classic_music, R.drawable.guitar};
    String[] styles = {"no preference", "classic", "rock", "jazz", "blues", "punk", "hip hop"};
    int styles_icons[] = {R.drawable.black_dot, R.drawable.classic_music, R.drawable.rock, R.drawable.jazz, R.drawable.blues,R.drawable.punk, R.drawable.hip_hop};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_for);
        listView = (ListView) findViewById(R.id.listview);
         Spinner spin = (Spinner) findViewById(R.id.simpleSpinner);
            spin.setOnItemSelectedListener(this);
        CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),symbols,instruments);
        spin.setAdapter(customAdapter);

            Spinner spin2 = (Spinner) findViewById(R.id.simpleSpinner2);
            CustomAdapter2 customAdapter2=new CustomAdapter2(getApplicationContext(),styles, styles_icons);
            spin2.setAdapter(customAdapter2);
            go_to_search_button = (ImageView) findViewById(R.id.search_view);

            go_to_search_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Search for here
                    //Add results to listview
                    //listView.setVisibility(View.VISIBLE);
                }
                });
        }


        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }

    }
