package ru.levelup.test.auto.java.intro.objects.equals;

public class ObjectEqualsExample {

    public static void main(String[] args) {
        Human dave = new Human();
        dave.setName("Dave");
        dave.setAge(20);

        Human judith = new Human();
        judith.setName("Judith");
        judith.setAge(20);

        Human david = new Human();
        david.setName("Dave");
        david.setAge(20);

        Human judithP = judith;

        System.out.println("dave equals judith -> " + dave.equals(judith));
        System.out.println("judithP equals judith -> " + judithP.equals(judith));
        System.out.println("dave equals david -> " + dave.equals(david));
        System.out.println();
        System.out.println("dave == judith -> " + (dave == judith));
        System.out.println("judithP == judith -> " + (judithP == judith));
        System.out.println("dave == david -> " + (dave == david));
    }

}
