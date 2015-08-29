package com.sparcedge.hackathon5.foodmate.foodmate.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.sparcedge.hackathon5.foodmate.foodmate.R;

/*
    This is the class that controls the login for the app
 */

public class Foodmate extends AppCompatActivity implements OnClickListener {
    public static final String PREFS_USER_NAMES = "UserNames";
    public static final String CURRENT_USER = "CurrentUser";

    private Button mLoginButton;
    private EditText mUsername;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodmate);

        mLoginButton = (Button) findViewById(R.id.buttonLogin);
        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);

        mLoginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = mUsername.getText().toString();
                final String password = mPassword.getText().toString();
                LogIn(username, password);
            }
        });

        InitializeUserSharedPreferences();
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

    //get the user name and pass it through to the GroceryList View
    @Override
    public void onClick(View v) {

    }

    private void LogIn(String username, String password) {
        if (null != username && null != password) {

            SharedPreferences users = getSharedPreferences(PREFS_USER_NAMES, 0);
            final String user1 = users.getString("User1", "");
            final String user2 = users.getString("User2", "");

            if (username.equals(user1) || username.equals(user2)) {
                Intent groceryIntent = new Intent(this, GroceryList.class);
                groceryIntent.putExtra(CURRENT_USER, username);
                startActivity(groceryIntent);
            }
        }
    }

    private void InitializeUserSharedPreferences() {
        SharedPreferences users = getSharedPreferences(PREFS_USER_NAMES, 0);
        SharedPreferences.Editor editor = users.edit();
        editor.putString("User1", "Bob");
        editor.putString("User2", "Alice");

        // Commit the edits!
        editor.commit();
    }
}
