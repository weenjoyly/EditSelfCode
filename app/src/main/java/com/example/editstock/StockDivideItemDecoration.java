package com.example.editstock;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class StockDivideItemDecoration extends RecyclerView.ItemDecoration {
    private Paint paint;
    public static final int DIVIDE_HEIGHT = 2;

    public StockDivideItemDecoration() {
        paint = new Paint();
        paint.setStrokeWidth(2f);
        paint.setColor(Color.parseColor("#323232"));
    }

    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.set(0, DIVIDE_HEIGHT, 0, DIVIDE_HEIGHT);
    }

    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            c.drawLine(parent.getLeft(), parent.getChildAt(i).getBottom(), parent.getRight(), parent.getChildAt(i).getBottom() + DIVIDE_HEIGHT, paint);
        }
    }
}
