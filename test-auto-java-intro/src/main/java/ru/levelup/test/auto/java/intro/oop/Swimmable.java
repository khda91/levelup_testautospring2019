package ru.levelup.test.auto.java.intro.oop;

public interface Swimmable {

    int CONSTT = 10;

    void swim();

    default void swimDef() {
        System.out.println("Swim def");
    }

}
