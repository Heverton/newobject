package com.pensejava.newobject.core;

/**
 * Configura as informações basicas de dados
 */
public class Config {
    private int countString;
    private int countInt;
    private int countPreciDecimal;

    public Config() {
    }

    public int getCountString() {
        return countString;
    }

    public void setCountString(int countString) {
        this.countString = countString;
    }

    public int getCountInt() {
        return countInt;
    }

    public void setCountInt(int countInt) {
        this.countInt = countInt;
    }

    public int getCountPreciDecimal() {
        return countPreciDecimal;
    }

    public void setCountPreciDecimal(int countPreciDecimal) {
        this.countPreciDecimal = countPreciDecimal;
    }
}
