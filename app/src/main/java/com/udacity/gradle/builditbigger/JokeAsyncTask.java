package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;
import android.widget.Toast;

import com.example.oscarfuentes.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by oscarfuentes on 30-12-15.
 */
public class JokeAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private JokeCallback mCallback;

    public void setCallback(JokeCallback l){
        mCallback=l;
    }
    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {
            MyApi.Builder builder = Config.DEBUG?new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl(Config.BACKEND_LOCAL_URL)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    }):
                    new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                            new AndroidJsonFactory(), null)
                            .setRootUrl(Config.BACKEND_URL)
                            .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                                @Override
                                public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                    abstractGoogleClientRequest.setDisableGZipContent(true);
                                }
                            });
            myApiService = builder.build();
        }
        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if(mCallback!=null) {
            if (result != null) {
                mCallback.onSuccess(result);
            }else{
                mCallback.onFail();
            }
        }
    }

    public interface JokeCallback{
        void onSuccess(String result);
        void onFail();
    }
}
