package com.udacity.gradle.builditbigger;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ak.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.studio.ak.imageactivity.Imageactivity;

import java.io.IOException;

/**
 * Created by Amal Krishnan on 13-09-2016.
 */
class EndpointAsyncTask extends AsyncTask<Context, Integer, String> {
    private MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {

        if(myApiService == null) {  // Only do this once

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-142617.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        context=params[0];

        try {
           return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        // Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        Log.d("MainActivity", "onPostExecute: RESULT ="+result);
        Intent myIntent = new Intent(context, Imageactivity.class);
        myIntent.putExtra(Intent.EXTRA_TEXT,result);
        context.startActivity(myIntent);
    }
}