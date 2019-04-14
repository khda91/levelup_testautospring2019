package ru.levelup.test.auto.java.intro.enums;

import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        List<Fruit> list = Arrays.asList(new Fruit("red", "round", FruitType.APPLE),
                new Fruit("yellow", "oval", FruitType.PEAR));
        Fruit fruit = getFruit(list, FruitType.PEAR);
        System.out.println(fruit.getColor() + " | " + fruit.getForm());
    }

    public static Fruit getFruit(final List<Fruit> list, FruitType fruitType) {
        for (Fruit fruit : list) {
            if (fruit.getFruitType().equals(fruitType)) {
                return fruit;
            }
        }
        return null;
    }
}
