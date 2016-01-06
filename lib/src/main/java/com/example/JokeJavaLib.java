package com.example;

import java.util.Random;

public class JokeJavaLib {

    private String[] mJokes={
            "Can a kangaroo jump higher than a house? Of course, a house doesn’t jump at all.",
            "Doctor: \"I'm sorry but you suffer from a terminal illness and have only 10 to live.\"\n" +
                    "Patient: \"What do you mean, 10? 10 what? Months? Weeks?!\"\n" +
                    "Doctor: \"Nine.",
            "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.",
            "What happens when you cross a snowman and a vampire? \n" +
                    "-\n" +
                    "A: You get a frostbite.",
            "Doctor: \"I'm sorry but you suffer from a terminal illness and have only 10 to live.\"\n" +
                    "Patient: \"What do you mean, 10? 10 what? Months? Weeks?!\"\n",
            "g"


    };
    private Random mRan =new Random();

    public String getJoke(){
        int size=mJokes.length;
        int i= mRan.nextInt(size-1);
        return mJokes[i];
    }
}
