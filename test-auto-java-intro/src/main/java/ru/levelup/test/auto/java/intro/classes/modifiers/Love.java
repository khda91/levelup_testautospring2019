package ru.levelup.test.auto.java.intro.classes.modifiers;

import ru.levelup.test.auto.java.intro.classes.Human;

public class Love {

    public void love(Human personOne, Human personTwo) {
        System.out.println(personOne.getName()
                + " love " + personTwo.getName() + " but "
                + personTwo.getName() + " is " + personTwo.getAge()
                + "years old");
    }

}
