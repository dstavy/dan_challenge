package com.scruff.danchallenge;

/**
 * Created by danstavy on 11/10/2017.
 */

public class City implements Place {

    private final String name;
    private final int pop;

    public City(String name, int pop) {
        this.name = name;
        this.pop = pop;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPop() {
        return pop;
    }
}
