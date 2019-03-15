package ru.levelup.test.auto.java.intro.classes;

public class HumanApp {

    public static void main(String[] args) {
        Human vasia = new Human();
        vasia.setName("Vasia");
        vasia.setAge(10);
        vasia.setGender("male");
        vasia.setBirthDate( "10/10/10");

        Human petia = new Human("Petia", "10/10/09", 20, "male");
    }

}
