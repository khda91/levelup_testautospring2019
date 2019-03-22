package ru.levelup.test.auto.java.intro.classes;

public class Friendship {

    private Human firstFriend;
    private Human secondFriend;

    public Friendship(Human firstFriend, Human secondFriend) {
        this.firstFriend = firstFriend;
        this.secondFriend = secondFriend;
    }

    public Human getFirstFriend() {
        return firstFriend;
    }

    public void setFirstFriend(Human firstFriend) {
        this.firstFriend = firstFriend;
    }

    public Human getSecondFriend() {
        return secondFriend;
    }

    public void setSecondFriend(Human secondFriend) {
        this.secondFriend = secondFriend;
    }

    @Override
    public String toString() {
        return "Friendship{" +
                "firstFriend=" + firstFriend +
                ", secondFriend=" + secondFriend +
                '}';
    }

    public void friendship() {
        System.out.println(String.format("%s has friendship with %s", firstFriend.getName(), secondFriend.getName()));
    }
}