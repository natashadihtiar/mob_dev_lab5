package com.example.lab5_1;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;


        import java.util.List;
import java.util.Random;

public class Adapter extends RecyclerView.Adapter<Holder> {

    private List<Integer> list;

    public Adapter(List<Integer> list, Context context) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter, viewGroup, false);
        Holder holder = new Holder(v);
        return holder;
    }

    @Override
    //задается цвет и значения
    public void onBindViewHolder(@NonNull Holder animalViewHolder, int i) {
        //рандомный цвет
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        ColorDrawable cd = new ColorDrawable(color);
        animalViewHolder.image.setImageDrawable(cd);
        //рандомная цифра из list
        String txt = String.valueOf(list.get(i));
        animalViewHolder.number.setText(txt);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
