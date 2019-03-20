package ru.levelup.test.auto.java.intro.oop;

import java.util.Objects;

public class Horse extends Animal {

    private double speed;
    private String color;
    private String type;

    @Override
    public void run() {
        System.out.println("Horse is running");
    }

    @Override
    public String scream() {
        return "иго-го";
    }

    @Override
    public String toString() {
        return "Horse{" +
                "speed=" + speed +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return Double.compare(horse.speed, speed) == 0 &&
                Objects.equals(color, horse.color) &&
                Objects.equals(type, horse.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(speed, color, type);
    }
}
