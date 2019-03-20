package ru.levelup.test.auto.java.intro.oop;

public class OopMain {

    public static void main(String[] args) {
        Dog charly = new Dog();
        Horse horse = new Horse();

        charly.eat();
        horse.eat();
        charly.swimDef();

        charly.swim();

        System.out.println(horse);
        System.out.println(charly);
    }
}
