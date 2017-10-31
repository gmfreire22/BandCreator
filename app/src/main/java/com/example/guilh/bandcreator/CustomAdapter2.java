package com.example.guilh.bandcreator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter2 extends BaseAdapter{
    Context context;
    String[] styles_names;
    int[] styles_pics;
    LayoutInflater inflater;

    public CustomAdapter2(Context context, String[] styles_names, int[] styles_pics){
        this.context = context;
        this.styles_names = styles_names;
        this.styles_pics = styles_pics;
        inflater = (LayoutInflater.from(context));
    }
    @Override
    public int getCount() {
        return styles_names.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.filtro2, null);
        ImageView icon = (ImageView) view.findViewById(R.id.imageView);
        TextView names = (TextView) view.findViewById(R.id.textView);
        icon.setImageResource(styles_pics[position]);
        names.setText(styles_names[position]);
        return view;    }
}
