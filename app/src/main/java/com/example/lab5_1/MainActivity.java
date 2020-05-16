package com.example.lab5_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyDialog.MyDialogListener  {
 List<Integer> data;
 RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //заполнение массива рандомными числами до 100
        data = new ArrayList<Integer>(24);
        for (int i=0;i<24;i++){
            int a = (int) (Math.random()*(100));
            data.add(a);
        }

        recycler = findViewById(R.id.list);
        //задание размеров
        recycler.setHasFixedSize(true);
        //отображение элементов на экране по 4 в строке
        recycler.setLayoutManager(new GridLayoutManager(this, 4));
        //подключение адаптера
        recycler.setAdapter(new Adapter(data, this));
        //событиенажатие на элемент
        recycler.addOnItemTouchListener(
                new Listener(this, recycler ,new Listener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        //вывод сообщения
                       String txt = data.get(position).toString();
                        //открытие диалога
                        MyDialog dialog = MyDialog.newInstance(txt);
                        dialog.show(getSupportFragmentManager(), "dlg");
                    }

                    @Override public void onItemClick2(View view, int position) {
                    }
                })
        );
    }
    @Override
    public void onMyDialogResult(String choice) {

    }
}
