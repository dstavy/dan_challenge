package com.scruff.danchallenge;

/**
 * Created by danstavy on 11/10/2017.
 */

public class State implements Place {
    private final String name;
    private int pop;
    private int numCities = 0;
    private City biggestCity = null;
    private City smallestCity = null;

    public State(String name) {
        this.name = name;
    }

    public int getAvgPop() {
        return pop / numCities;
    }

    public City getBigestCity() {
        return biggestCity;
    }

    public City getSmallestCity() {
        return smallestCity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPop() {
        return pop;
    }

    public void addCity(City city) {
        this.numCities++;
        this.pop += city.getPop();

        if (smallestCity == null) { // first insertion
            biggestCity = smallestCity = city;
        } else {
            if (city.getPop() < smallestCity.getPop()) {
                smallestCity = city;
            } else if (city.getPop() > biggestCity.getPop()) {
                biggestCity = city;
            }
        }
    }
}
