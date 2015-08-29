package com.sparcedge.hackathon5.foodmate.foodmate.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.sparcedge.hackathon5.foodmate.foodmate.R;
import com.sparcedge.hackathon5.foodmate.foodmate.api.DialogOnClickListener;
import com.sparcedge.hackathon5.foodmate.foodmate.api.GroceryListItem;
import com.sparcedge.hackathon5.foodmate.foodmate.views.AddGroceryListRowDialog;
import com.sparcedge.hackathon5.foodmate.foodmate.views.GroceryListItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * this class is the actual list view
 */
public class GroceryList extends AppCompatActivity implements OnClickListener, DialogOnClickListener {

    Button addItem = null;
    Button saveList = null;
    GroceryListItemView groceryListItemView = null;
    AddGroceryListRowDialog addGroceryListRowDialog = null;
    private String mCurrentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list);
        addItem = (Button)findViewById(R.id.grocery_list_button);
        saveList = (Button)findViewById(R.id.save_grocery_list_button);
        groceryListItemView = (GroceryListItemView)findViewById(R.id.grocery_list);
        addGroceryListRowDialog = new AddGroceryListRowDialog();
        addItem.setOnClickListener(this);
        saveList.setOnClickListener(this);

        // Get the current user and set the title using the username.
        SetTitleToCurrentUser(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_foodmate, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v == addItem) {
            addGroceryListRowDialog.show(getSupportFragmentManager(), "dialog");
        } else if (v == saveList) {
            SaveGroceryList();
        }
    }

    @Override
    public void onAcceptClick() {
        groceryListItemView.addRow(addGroceryListRowDialog.getSelectedChoice());
    }

    @Override
    public void onDeclineClick(DialogInterface dialog) {
        dialog.cancel();
    }

    private void SetTitleToCurrentUser(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            mCurrentUser = extras.getString(Foodmate.CURRENT_USER);
            setTitle(mCurrentUser + "'s " + getTitle());
        } else {
            mCurrentUser = savedInstanceState.getString(Foodmate.CURRENT_USER);
        }
    }

    private void SaveGroceryList() {
        List<GroceryListItem> groceries = new ArrayList<>();

        for(int i = 0; i < groceryListItemView.getChildCount(); i++)
        {
            LinearLayout row = (LinearLayout) groceryListItemView.getChildAt(i);

            GroceryListItem groceryItem = new GroceryListItem();

            groceryItem.setId(Integer.toString(i));

            EditText editDescription = (EditText) row.getChildAt(0);
            groceryItem.setDescription(editDescription.getText().toString());

            CheckBox checkBox = (CheckBox) row.getChildAt(1);
            groceryItem.setChecked(checkBox.isChecked());

            groceries.add(groceryItem);
        }

        if (!groceries.isEmpty()) {
            Toast.makeText(
                    this, "There are " + groceries.size() + " groceries in the list",
                    Toast.LENGTH_LONG).show();
        }
    }
}
