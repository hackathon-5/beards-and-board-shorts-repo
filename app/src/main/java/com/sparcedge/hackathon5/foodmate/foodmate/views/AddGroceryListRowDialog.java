package com.sparcedge.hackathon5.foodmate.foodmate.views;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.sparcedge.hackathon5.foodmate.foodmate.R;
import com.sparcedge.hackathon5.foodmate.foodmate.activities.GroceryList;

/**
 * Created by developer on 8/28/2015.
 */
public class AddGroceryListRowDialog extends DialogFragment {

    public static final int DRY_FOOD        = 0;
    public static final int PRODUCE         = 1;
    public static final int FROZEN_FOOD     = 2;
    public static final int HOUSEHOLD_ITEM  = 3;

    private int selectedChoice;
    private GroceryList activity;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        activity = (GroceryList) getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Select Item Type")
                .setSingleChoiceItems(R.array.item_types, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedChoice = which;
                    }
                })
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        activity.onAcceptClick();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        activity.onDeclineClick(dialog);
                    }
                });
        return builder.create();
    }

    public int getSelectedChoice(){ return selectedChoice;}
}
