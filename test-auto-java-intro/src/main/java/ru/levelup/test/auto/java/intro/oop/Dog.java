package ru.levelup.test.auto.java.intro.oop;

public class Dog extends Animal implements Swimmable, Flyable {

    private String name;
    private int age;

    public Dog() {
        size = 10.0;
        domestic = true;
    }

    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }

    @Override
    public void run() {
        System.out.println("Dog is running");
    }

    @Override
    public String scream() {
        return "гав-гав";
    }

    @Override
    public void swim() {
        System.out.println("Dog is swimming");
    }
}
