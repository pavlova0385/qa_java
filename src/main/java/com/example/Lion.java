package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    private final Predator predator;
    private final int kittens;

    public Lion(String sex, Predator predator, int kittens) throws Exception {
        this.predator = predator;
        this.kittens = kittens;

        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public int getKittens() {
        return kittens;
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }
}