package ru.levelup.test.auto.java.intro.enums;

public class Fruit {

    private String color;
    private String form;
    private FruitType fruitType;

    public Fruit() {
    }

    public Fruit(String color, String form, FruitType fruitType) {
        this.color = color;
        this.form = form;
        this.fruitType = fruitType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public FruitType getFruitType() {
        return fruitType;
    }
}
