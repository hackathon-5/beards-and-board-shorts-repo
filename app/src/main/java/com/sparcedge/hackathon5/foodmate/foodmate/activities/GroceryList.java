package com.sparcedge.hackathon5.foodmate.foodmate.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.sparcedge.hackathon5.foodmate.foodmate.R;
import com.sparcedge.hackathon5.foodmate.foodmate.views.GroceryListItemView;

/**
 * this class is the actual list view
 */
public class GroceryList extends AppCompatActivity implements OnClickListener{

    TextView total = null;
    Button addItem = null;
    GroceryListItemView groceryListItemView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.activity_foodmate);
        total = (TextView)findViewById(R.id.grocery_list_total);
        addItem = (Button)findViewById(R.id.grocery_list_button);
        groceryListItemView = (GroceryListItemView)findViewById(R.id.grocery_list);
        addItem.setOnClickListener(this);
=======
        setContentView(R.layout.activity_grocery_list);
>>>>>>> d47b2b72e78e074a613dc0a186b7a4e5382f8747
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
        if(v == addItem){
            groceryListItemView.addRod();
        }
    }

}
