package com.example.wtf;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;


public class HomeSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int space;
    private int count;

    public HomeSpaceItemDecoration(int count, int space) {
        this.space = space;
        this.count = count;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (parent.getChildAdapterPosition(view) >= count) {
            outRect.top = space;
        } else {
            outRect.top = 0;
        }

    }
}