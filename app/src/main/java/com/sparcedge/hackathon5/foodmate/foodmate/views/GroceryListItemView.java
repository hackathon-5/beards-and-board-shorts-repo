package com.sparcedge.hackathon5.foodmate.foodmate.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;

import com.sparcedge.hackathon5.foodmate.foodmate.R;

/**
 * Created by developer on 8/28/2015.
 */
public class GroceryListItemView extends TableLayout {

    public GroceryListItemView(Context context) {
        super(context, null);
    }

    public GroceryListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void addRod(){
        addView(createRow());
    }

    private View createRow(){
        View v;
        LayoutInflater inflater = LayoutInflater.from(getContext());
        v = inflater.inflate(R.layout.grocery_list_row, this, false);
        return v;
    }
}
