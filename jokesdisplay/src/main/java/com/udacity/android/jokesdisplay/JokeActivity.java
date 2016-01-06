package com.udacity.android.jokesdisplay;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by oscarfuentes on 11-12-15.
 */
public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_EXTRA="jokeextra";

    private TextView mJokeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_layout);
        mJokeText=(TextView) findViewById(R.id.joke_textView);

        Intent i= getIntent();
        if(i!=null){
            Bundle e= i.getExtras();
            if(e!=null){
                mJokeText.setText(e.getString(JOKE_EXTRA, ""));
            }
        }
    }

}
