package com.example.editstock;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class SelfcodeViewHolder extends RecyclerView.ViewHolder {

    List<TextView> textViewList;
    TextView name;
    HorizontalScrollView horizontalScrollView;

    public SelfcodeViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewList = new ArrayList<>();
        textViewList.add((TextView) itemView.findViewById(R.id.item1));
        textViewList.add((TextView) itemView.findViewById(R.id.item2));
        textViewList.add((TextView) itemView.findViewById(R.id.item3));
        textViewList.add((TextView) itemView.findViewById(R.id.item4));
        textViewList.add((TextView) itemView.findViewById(R.id.item5));
        textViewList.add((TextView) itemView.findViewById(R.id.item6));
        textViewList.add((TextView) itemView.findViewById(R.id.item7));
        textViewList.add((TextView) itemView.findViewById(R.id.item8));
        textViewList.add((TextView) itemView.findViewById(R.id.item9));
        textViewList.add((TextView) itemView.findViewById(R.id.item10));
        textViewList.add((TextView) itemView.findViewById(R.id.item11));
        textViewList.add((TextView) itemView.findViewById(R.id.item12));
        textViewList.add((TextView) itemView.findViewById(R.id.item13));
        textViewList.add((TextView) itemView.findViewById(R.id.item14));
        textViewList.add((TextView) itemView.findViewById(R.id.item15));
        textViewList.add((TextView) itemView.findViewById(R.id.item16));
        textViewList.add((TextView) itemView.findViewById(R.id.item17));
        textViewList.add((TextView) itemView.findViewById(R.id.item18));
        textViewList.add((TextView) itemView.findViewById(R.id.item19));
        textViewList.add((TextView) itemView.findViewById(R.id.item20));
        textViewList.add((TextView) itemView.findViewById(R.id.item21));
        textViewList.add((TextView) itemView.findViewById(R.id.item22));
        textViewList.add((TextView) itemView.findViewById(R.id.item23));
        textViewList.add((TextView) itemView.findViewById(R.id.item24));
        textViewList.add((TextView) itemView.findViewById(R.id.item25));
        textViewList.add((TextView) itemView.findViewById(R.id.item26));
        textViewList.add((TextView) itemView.findViewById(R.id.item27));
        textViewList.add((TextView) itemView.findViewById(R.id.item28));
        textViewList.add((TextView) itemView.findViewById(R.id.item29));
        textViewList.add((TextView) itemView.findViewById(R.id.item30));
        textViewList.add((TextView) itemView.findViewById(R.id.item31));
        horizontalScrollView = (HorizontalScrollView) itemView.findViewById(R.id.scroller);
        name = itemView.findViewById(R.id.name);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
    }

    public void setOnScrollChangeListener(View.OnScrollChangeListener l) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            horizontalScrollView.setOnScrollChangeListener(l);
        }
    }

    public void update(List<String> list) {
        name.setText(list.get(1) + "\n" + list.get(0));
        int color = Color.BLACK;
        if (list.size() == 1) {
            Log.d(TAG, "update: " + list.get(0));
        }
        if (Double.parseDouble(list.get(2)) > Double.parseDouble(list.get(3))) {
            color = Color.RED;
        } else if (Double.parseDouble(list.get(2)) < Double.parseDouble(list.get(3))) {
            color = Color.GREEN;
        }
        for (int i = 0; i < textViewList.size(); i++) {
            textViewList.get(i).setText(list.get(i + 2));
            textViewList.get(i).setTextColor(color);
            textViewList.get(i).setGravity(Gravity.CENTER);
        }
    }

}
