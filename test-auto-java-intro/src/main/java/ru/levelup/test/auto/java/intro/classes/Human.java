package ru.levelup.test.auto.java.intro.classes;

public class Human {

    private String name;
    private String birthDate;
    private int age;
    private String gender;

    public Human() {
    }

    public Human(String name, String birthDate, int age) {
//        this(name, birthDate, age, "");

        this.name = name;
        this.birthDate = birthDate;
        this.age = age;
    }

    public Human(String name, int age, String gender) {
//        this(name, birthDate, age, "");

        this.name = name;
//        this.birthDate = "19/12/1900";
        this.age = age;
        this.gender = gender;
    }

    public Human(String name, String birthDate, int age, String gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
