package com.example.guilh.bandcreator;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int instruments_pics[];
    String[] instruments_names;
    LayoutInflater inflater;

    public CustomAdapter(Context applicationContext, int[] instruments_pics, String[] instruments_names) {
        this.context = applicationContext;
        this.instruments_pics = instruments_pics;
        this.instruments_names = instruments_names;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return instruments_pics.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.filtro, null);
        ImageView icon = (ImageView) view.findViewById(R.id.imageView);
        TextView names = (TextView) view.findViewById(R.id.textView);
        icon.setImageResource(instruments_pics[i]);
        names.setText(instruments_names[i]);
        return view;
    }
}