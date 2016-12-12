package com.pensejava.newobject.core;

/**
 * Configura as informações basicas de dados
 */
public class Config {

    private int countList = 1;
    private int countListDependent = 1;
    private int countString  = 10;
    private int countNumber = 100;

    public Config() {
    }

    public int getCountList() {
        return countList;
    }

    public void setCountList(int countList) {
        this.countList = countList;
    }

    public int getCountListDependent() {
        return countListDependent;
    }

    public void setCountListDependent(int countListDependent) {
        this.countListDependent = countListDependent;
    }

    public int getCountString() {
        return countString;
    }

    public void setCountString(int countString) {
        this.countString = countString;
    }

    public int getCountNumber() {
        return countNumber;
    }

    public void setCountNumber(int countNumber) {
        this.countNumber = countNumber;
    }
}
