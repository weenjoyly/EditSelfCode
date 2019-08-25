package com.example.editstock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.HorizontalScrollView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self);
        RecyclerView recyclerViewdemo = findViewById(R.id.recyclerview);
        HorizontalScrollView scrollView = findViewById(R.id.scroller);
        new SelfcodeRecyclerView().init(recyclerViewdemo, scrollView);
        scrollView.setHorizontalScrollBarEnabled(false);
    }
}
