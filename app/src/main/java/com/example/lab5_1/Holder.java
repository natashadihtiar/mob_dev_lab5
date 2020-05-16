package com.example.lab5_1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Holder extends RecyclerView.ViewHolder {

    public CircleImageView image;
    public TextView number;

    public Holder(@NonNull View itemView) {
        super(itemView);
        //посик картинки
        image = itemView.findViewById(R.id.image);
        //поиск числа
        number = itemView.findViewById(R.id.number);

    }
}