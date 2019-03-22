package ru.levelup.test.auto.java.intro.classes;

public class HumanApp {

    public static void main(String[] args) {
        Human vasia = new Human();
        vasia.setName("Vasia");
        vasia.setAge(10);
        vasia.setGender("male");
        vasia.setBirthDate("10/10/10");

        Human petia = new Human("Petia", "10/10/09", 20, "male");

        new Friendship(new Human("Name1", "03.04.90", 28),
                new Human("Name2", 28, "male")).friendship();
    }

}
