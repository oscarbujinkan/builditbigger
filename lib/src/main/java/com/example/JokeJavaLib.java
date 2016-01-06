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
            "I used to think the brain was the most important organ. Then I thought, look what’s telling me that.",
            " It’s hard to explain puns to kleptomaniacs because they always take things literally.",
            "The midget fortune teller who kills his customers is a small medium at large.",
            "What does a nosey pepper do? Get jalapeño business.",
            "What is Bruce Lee’s favorite drink? Wataaaaah!",
            " The dyslexic devil worshipper sold his soul to Santa.",
            "You kill vegetarian vampires with a steak to the heart.",
            " If you want to catch a squirrel just climb a tree and act like a nut.",
            "So this guy with a premature ejaculation problem comes out of nowhere.",
            "A magician was walking down the street and turned into a grocery store.",
            "A blind man walks into a bar. And a table. And a chair.",
            "How does NASA organize their company parties? They planet.",
            "What kind of shoes do ninjas wear? Sneakers.",
            "What time is it when you have to go to the dentist? Tooth-hurtie.",
            "My friend recently got crushed by a pile of books, but he’s only got his shelf to blame."

    };
    private Random mRan =new Random();

    public String getJoke(){
        int size=mJokes.length;
        int i= mRan.nextInt(size-1);
        return mJokes[i];
    }
}
