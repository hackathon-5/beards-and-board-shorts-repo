package com.sparcedge.hackathon5.foodmate.foodmate.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.sparcedge.hackathon5.foodmate.foodmate.R;
import com.sparcedge.hackathon5.foodmate.foodmate.api.DialogOnClickListener;
import com.sparcedge.hackathon5.foodmate.foodmate.views.AddGroceryListRowDialog;
import com.sparcedge.hackathon5.foodmate.foodmate.views.GroceryListItemView;

/**
 * this class is the actual list view
 */
public class GroceryList extends AppCompatActivity implements OnClickListener, DialogOnClickListener {

    Button addItem = null;
    GroceryListItemView groceryListItemView = null;
    AddGroceryListRowDialog addGroceryListRowDialog = null;
    private String mCurrentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list);
        addItem = (Button)findViewById(R.id.grocery_list_button);
        groceryListItemView = (GroceryListItemView)findViewById(R.id.grocery_list);
        addGroceryListRowDialog = new AddGroceryListRowDialog();
        addItem.setOnClickListener(this);

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
}
