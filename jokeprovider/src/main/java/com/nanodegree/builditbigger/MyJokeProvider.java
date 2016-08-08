package com.nanodegree.builditbigger;

import java.util.Random;

public class MyJokeProvider {

    Random mRandom = new Random();

    public MyJokeProvider() {
    }

    /**
     * Gets a random joke from the data store
     *
     * @return The selected joke
     */
    public String getJoke() {
        int selected = mRandom.nextInt(MyJokes.jokes.length);
        return MyJokes.jokes[selected];
    }
}
