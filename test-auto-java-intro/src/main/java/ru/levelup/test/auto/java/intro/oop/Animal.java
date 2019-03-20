package ru.levelup.test.auto.java.intro.oop;

public abstract class Animal {// extends Object {

    public static final int CONSTT = 10;

    protected double weight;
    protected double size;
    protected boolean domestic;

    public abstract String scream();

    public abstract void run();

    public void eat() {
        System.out.println("Animal is eating");
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public boolean isDomestic() {
        return domestic;
    }

    public void setDomestic(boolean domestic) {
        this.domestic = domestic;
    }

}
