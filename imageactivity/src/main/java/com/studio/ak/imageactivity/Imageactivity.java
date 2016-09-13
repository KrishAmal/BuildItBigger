package com.studio.ak.imageactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by Amal Krishnan on 17-08-2016.
 */
public class Imageactivity extends AppCompatActivity {
    private  String op;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getIntent()!=null)
            op=getIntent().getStringExtra(Intent.EXTRA_TEXT);
        Log.d("Imageactivity", "onCreate: O/P="+op);
        Bundle bundle = new Bundle();
        bundle.putString("joke",op);
        setContentView(R.layout.android_lib_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_image, menu);
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

    public void launchLibraryActivity(View view){
        Intent myIntent = new Intent(this, Imageactivity.class);
        startActivity(myIntent);
    }


}
