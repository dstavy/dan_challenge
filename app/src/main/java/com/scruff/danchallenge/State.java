package com.scruff.danchallenge;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by danstavy on 11/10/2017.
 */

public class State implements Place {
    private final String name;
    private int pop;
    private Map<String, City> cities;
    private City biggestCity = null;
    private City smallestCity = null;

    public State(String name) {
        this.name = name;
        cities = new HashMap<String, City>();
    }

    public int getAvgPop() {
        return pop / cities.size();
    }

    public City getBiggestCity() {
        int pop = 0;
        if (biggestCity == null) { // first call
            for (Map.Entry<String, City> city : cities.entrySet()) {
                if (city.getValue().getPop() > pop) {
                    biggestCity = city.getValue();
                    pop = city.getValue().getPop();
                }
            }
        }

        return biggestCity;
    }

    public City getSmallestCity() {
        int pop = Integer.MAX_VALUE;
        if (smallestCity == null) { // first call
            for (Map.Entry<String, City> city : cities.entrySet()) {
                if (city.getValue().getPop() < pop) {
                    smallestCity = city.getValue();
                    pop = city.getValue().getPop();
                }
            }
        }
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
        if (!cities.containsKey(city.getName())) {
            cities.put(city.getName(), city);
        } else {
            City c = cities.get(city.getName());
            c.setPop(city.getPop() + c.getPop());
        }

        this.pop += city.getPop();
    }
}
