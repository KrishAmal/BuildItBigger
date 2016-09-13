package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;

import com.udacity.gradle.jokes.Joker;

import org.mockito.Mock;

import java.util.concurrent.TimeUnit;

/**
 * Created by Amal Krishnan on 13-09-2016.
 */
public class EndpointAsyncTaskTest extends AndroidTestCase {

    //Joker joker=new Joker();
    EndpointAsyncTask endpointAsyncTask;
    String result;
    @Mock Context mockContext;

    @Override
    protected void setUp() throws Exception {

        endpointAsyncTask =new EndpointAsyncTask(){

            protected void onPostExecute(String joke){
                //No need to launch intent, so override this method
            }
        };
    }

    public void testAsyncReturnType() {

        try{

            //Default timeout for the GCM server is 20 seconds
            //If the .get can't get the result in 10 seconds, something is wrong anyway
            //Greater than 20 seconds results in an error string returned and requires further interpretation
            //endpointAsyncTask.execute(new android.util.Pair<Context, String>(mockContext,joker.getJoke() ));
            endpointAsyncTask.execute();
            result = endpointAsyncTask.get(10, TimeUnit.SECONDS);
            assertNotNull(result);

        }catch (Exception e){
            fail("Timed out");
        }
    }

}
