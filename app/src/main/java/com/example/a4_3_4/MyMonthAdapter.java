package com.example.a4_3_4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class MyMonthAdapter extends ArrayAdapter<MyMonth> {

    public MyMonthAdapter(Context context, MyMonth[] arr) {
        super(context, R.layout.adapter_item, arr);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final MyMonth month = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item, null);
        }

// Заполняем адаптер
        ((TextView) convertView.findViewById(R.id.textView)).setText(month.month);
        ((TextView) convertView.findViewById(R.id.textView2)).setText(String.valueOf(month.temp));
        ((TextView) convertView.findViewById(R.id.textView3)).setText(String.valueOf(month.days));
// Выбираем картинку для месяца
        if (month.temp > 0.)
            ((ImageView) convertView.findViewById(R.id.imageView)).setImageResource(R.drawable.sun);
        else
            ((ImageView) convertView.findViewById(R.id.imageView)).setImageResource(R.drawable.snow);

        CheckBox ch = (CheckBox) convertView.findViewById(R.id.checkBox);
        ch.setChecked(month.like);
        ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                month.like = ((CheckBox) v).isChecked();
            }
        });
        return convertView;
    }
}
