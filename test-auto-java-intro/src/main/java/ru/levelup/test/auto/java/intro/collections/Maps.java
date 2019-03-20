package ru.levelup.test.auto.java.intro.collections;

import ru.levelup.test.auto.java.intro.objects.equals.Human;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Maps {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
//        Map<String, String> map = new LinkedHashMap<>();
//        Map<String, String> map = new TreeMap<>();
        map.put("papa", "papa");
        map.put("mama", "mama");
        map.put("papa", "papa");
        map.put("zzzzzzz", "zzzzzzzzz");
        map.put("pele", "pepe");
        map.put("mama", "papa");

        System.out.println(map);

        Human dave = new Human();
        dave.setName("Dave");
        dave.setAge(20);

        Human judith = new Human();
        judith.setName("Judith");
        judith.setAge(20);

        Human david = new Human();
        david.setName("Dave");
        david.setAge(20);

        Map<Human, Human> humanSet = new HashMap<>();
        humanSet.put(dave, dave);
        humanSet.put(judith, judith);
        humanSet.put(david, judith);

        System.out.println(humanSet);

    }

}
