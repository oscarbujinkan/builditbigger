package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import java.util.concurrent.CountDownLatch;

public class ApplicationTest extends ApplicationTestCase<Application> {

    private CountDownLatch mSignal = null;
    private String mResult;
    private static final int NUMBER_OF_TEST=10;

    public ApplicationTest() {
        super(Application.class);
    }
    @Override
    protected void setUp() throws Exception {
        mSignal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        mSignal.countDown();
    }
    public void testExecution() throws InterruptedException {
        for (int i=0; i<NUMBER_OF_TEST;i++){
            testJokeGetTask();
            mSignal.await();
            if(mResult.equals("")){
                Log.d("TEST", "testExecution: nada");
            }
            assertTrue(!mResult.isEmpty());
        }
    }

    private void testJokeGetTask() throws InterruptedException {

        JokeAsyncTask jokeAsyncTask = new JokeAsyncTask();
        jokeAsyncTask.setCallback(new JokeAsyncTask.JokeCallback() {
            @Override
            public void onSuccess(String result) {
                mResult = result;
                mSignal.countDown();
            }

            @Override
            public void onFail() {
                mResult="";
                mSignal.countDown();
            }
        });
        jokeAsyncTask.execute();
    }

}