package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.JokeJavaLib;
import com.udacity.android.jokesdisplay.JokeActivity;


public class MainActivity extends AppCompatActivity {

    private JokeJavaLib mJokes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mJokes=new JokeJavaLib();
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){

        JokeAsyncTask asyncJoke=new JokeAsyncTask();
        asyncJoke.setCallback(new JokeAsyncTask.JokeCallback() {
            @Override
            public void onSuccess(String result) {
                launchLibraryActivity(result);
            }

            @Override
            public void onFail() {
                Toast.makeText(MainActivity.this,"Can't get the joke from the 'jokemaker'. Please try again later.", Toast.LENGTH_LONG).show();
            }
        });
        asyncJoke.execute();

//        Toast.makeText(this, , Toast.LENGTH_SHORT).show();
    }


    public void launchLibraryActivity(String joke){
        Intent myIntent = new Intent(this, JokeActivity.class);
        myIntent.putExtra(JokeActivity.JOKE_EXTRA,joke);
        startActivity(myIntent);
    }


}
