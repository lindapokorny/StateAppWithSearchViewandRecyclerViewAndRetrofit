package com.pursuit.statesappfromscratchsearchview.model;

public class State {
    private final String name;

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    private final String capital;

    public State(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }

}
