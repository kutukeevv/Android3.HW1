package com.example.android3lesson1.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;

import com.example.android3lesson1.R;
import com.example.android3lesson1.data.Card;

@RequiresApi(api = Build.VERSION_CODES.R)
public class MainActivity extends AppCompatActivity{

    private final EmojiCardAdapter cardAdapter = new EmojiCardAdapter();

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.cardList);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(cardAdapter);
    }

}