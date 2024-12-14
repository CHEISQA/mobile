package com.ensa.marhbabik;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class OptionAdapter extends BaseAdapter {

    private List<OptionItem> optionList;
    private Context context;

    public OptionAdapter(Context context, List<OptionItem> optionList) {
        this.context = context;
        this.optionList = optionList;
    }

    @Override
    public int getCount() {
        return optionList.size();
    }

    @Override
    public Object getItem(int position) {
        return optionList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.option_item, parent, false);
        }

        OptionItem currentItem = optionList.get(position);

        ImageView imgOption = convertView.findViewById(R.id.img_option);
        TextView tvOptionTitle = convertView.findViewById(R.id.tv_option_title);
        TextView tvOptionSubtitle = convertView.findViewById(R.id.tv_option_subtitle);
        Button btnDetail = convertView.findViewById(R.id.btn_detail);

        imgOption.setImageResource(currentItem.getImageResId());
        tvOptionTitle.setText(currentItem.getTitle());
        tvOptionSubtitle.setText(currentItem.getSubtitle());

        // Optional: Set up button click listener
        btnDetail.setOnClickListener(v -> {
            // Handle button click event here
        });

        return convertView;
    }
}

