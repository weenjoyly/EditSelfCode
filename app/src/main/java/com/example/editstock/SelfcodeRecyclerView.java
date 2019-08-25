package com.example.editstock;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.HorizontalScrollView;

public class SelfcodeRecyclerView {
    public void init(RecyclerView recyclerView, HorizontalScrollView scrollView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        final SelfcodeAdapter adapter = new SelfcodeAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new StockDivideItemDecoration());
        adapter.addHeadScrollerView(scrollView);
    }

}
