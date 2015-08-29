package com.sparcedge.hackathon5.foodmate.foodmate.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;

import com.sparcedge.hackathon5.foodmate.foodmate.R;

/**
 * Created by developer on 8/28/2015.
 */
public class GroceryListItemView extends TableLayout {

    int mRows = 0;
    int[] rows;

    public GroceryListItemView(Context context) {
        super(context, null);
    }

    public GroceryListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void addRod(int style){
        switch (style){
            case AddGroceryListRowDialog.DRY_FOOD:
                addView(createRow(style),rows[AddGroceryListRowDialog.DRY_FOOD]);
                updateRowCounts(AddGroceryListRowDialog.DRY_FOOD);
                break;
            case AddGroceryListRowDialog.PRODUCE:
                addView(createRow(style),rows[AddGroceryListRowDialog.PRODUCE]);
                updateRowCounts(AddGroceryListRowDialog.PRODUCE);
                break;
            case AddGroceryListRowDialog.FROZEN_FOOD:
                addView(createRow(style),rows[AddGroceryListRowDialog.FROZEN_FOOD]);
                updateRowCounts(AddGroceryListRowDialog.FROZEN_FOOD);
                break;
            case AddGroceryListRowDialog.HOUSEHOLD_ITEM:
                addView(createRow(style),rows[AddGroceryListRowDialog.HOUSEHOLD_ITEM]);
                updateRowCounts(AddGroceryListRowDialog.HOUSEHOLD_ITEM);
                break;
            default:
                break;
        }

    }

    private View createRow(int style){
        View v;
        LayoutInflater inflater = LayoutInflater.from(getContext());
        if(style == AddGroceryListRowDialog.PRODUCE){
            v = inflater.inflate(R.layout.grocery_list_row_produce, this, false);
        }else {
            v = inflater.inflate(R.layout.grocery_list_row, this, false);
        }
        setItemBackground(v, style);
        return v;
    }

    private void setItemBackground(View item, int style){
        Drawable background;
        switch (style){
            case AddGroceryListRowDialog.DRY_FOOD:
                background = ContextCompat.getDrawable(getContext(), R.drawable.dry_goods_background);
                item.setBackground(background);
                break;
            case AddGroceryListRowDialog.PRODUCE:
                background = ContextCompat.getDrawable(getContext(), R.drawable.produce_background);
                item.setBackground(background);
                break;
            case AddGroceryListRowDialog.FROZEN_FOOD:
                background = ContextCompat.getDrawable(getContext(), R.drawable.frozen_food_background);
                item.setBackground(background);
                break;
            case AddGroceryListRowDialog.HOUSEHOLD_ITEM:
                background = ContextCompat.getDrawable(getContext(), R.drawable.household_item_background);
                item.setBackground(background);
                break;
            default:
                break;
        }
    }

    private void updateRowCounts(int updatedRow){
        mRows++;
        for(int i = 0; i < getResources().getInteger(R.integer.row_types); i++){
            if(i >= updatedRow){
                rows[i] = ++rows[i];
            }
        }
    }
}
