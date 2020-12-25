package com.example.recipe_converter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import static com.example.recipe_converter.Utils.showInfoDialog;

public class MainActivity extends AppCompatActivity {
    private Snackbar mSnackBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setUpFAB();
        mSnackBar =
                Snackbar.make(findViewById(android.R.id.content), "Welcome!",
                        Snackbar.LENGTH_LONG);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

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
            showSettings();
            return true;
        }
        else if (id == R.id.action_about){
            showAbout();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showSettings() {
        dismissSnackBarIfShown();
        Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivityForResult(intent, 1);
    }

   private void dismissSnackBarIfShown() {
        if (mSnackBar.isShown()) {
            mSnackBar.dismiss();
        }
    }
    private void showAbout() {
        showInfoDialog(this, R.string.app_name, R.string.about_message);
    }

    private void setUpFAB() {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSnackBar.isShown()) {
                    mSnackBar.dismiss();
                }
                mSnackBar.setText("See recipe favorites in your preferred number of batches...")
                        .show();
               /* Intent intent = new Intent(getApplicationContext(), IngredientActivity.class);
              //intent.putExtra("GAME", mGame.getJSONFromCurrentGame());
                startActivity(intent);*/
            }
        });
    }

    public void pickNumberOfBatches(View view) {
        Button button = (Button)view;
        String buttonText = button.getText().toString();
        double factor = buttonText.equals("1/2") ? .5 : Double.parseDouble(buttonText);

        Intent intent = new Intent(getApplicationContext(), IngredientActivity.class);
        intent.putExtra("FACTOR", factor);
        startActivity(intent);
    }
}