package ru.levelup.test.auto.java.intro.exceptions;

public class Price {

    Integer one;
    Double two;
    Long three;

    public Price(int one) {
        this.one = one;
    }

    public Price(double two) {
        this.two = two;
    }

    public Price(long three) {
        this.three = three;
    }

    Number getN() {
        if (one != null) {
            return one;
        } else if (two != null) {
            return two;
        }
        return three;
    }
}
