package ru.levelup.test.auto.java.intro;

public class ConditionOperation {

    public static void main(String[] args) {
        boolean condition = true;

        // If else

        if (condition)
            System.out.println();
        else
            System.out.println("ConditionOperation.main");

        // switch int
        switchInt(0);    // switchInt(0);
        switchInt(50);
        switchInt(90);
        switchInt(92);

        // switch string
        switchString("mama");
        switchString("deda");
        switchString("baba");
        switchString("dede");

        // switch enum
        switchEnum(Colors.BLUE);
        switchEnum(Colors.GREEN);
        switchEnum(Colors.BLUE);


        // ternary oper
        int max = 0;
        // ... some code ...
        int x = 7;
        int y = 9;
        max = x > y ? x : max;
//        int max = x > y ? x : max; - does not work


        // while
        int count = 0;

        while (count < 10) {
            System.out.println("count value: -> " + count);
            count++;
        }

        System.out.println();
        // do while
        do {
            System.out.println("count value: -> " + count);
            count++;
        } while (count <= 11);
        System.out.println();

        // for
        int[] mass = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < mass.length; i++) {
            System.out.println(mass[i]);
        }
        System.out.println();

        // for each
        for (int num : mass) {
            System.out.println(num);
        }
        System.out.println();

        // for break
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] == 7) {
                break;
            }
            System.out.println(mass[i]);
        }
        System.out.println();

        // for continue
        for (int num : mass) {
            if (num % 2 == 0) {
                continue;
            }
            System.out.println(num);
        }
        System.out.println();

    }

    static void switchInt(int a) {
        switch (a) {
            case 0:
                System.out.println(0);
                break;

            case 1:
                System.out.println(1);
                break;

            case 50:
                System.out.println(50);
                break;

            case 90:
                System.out.println(90);
                break;
            case 92:
                System.out.println(92);
                break;
        }
        System.out.println();
    }

    static void switchString(String str) {
        switch (str) {
            case "mama":
                System.out.println(str);
                break;

            case "papa":
                System.out.println(str);
                break;

            case "baba":
                System.out.println(str);
                break;

            case "dada":
                System.out.println(str);
                break;

            case "deda":
                System.out.println(str);
                break;
        }
        System.out.println();
    }

    static void switchEnum(Colors color) {
        switch (color) {
            case BLUE:
                System.out.println(color);
                break;

            case GREEN:
                System.out.println(color);
                break;

            case RED:
                System.out.println(color);
                break;

            case WHITE:
                System.out.println(color);
                break;
        }
        System.out.println();
    }

    static enum Colors {

        RED,
        GREEN,
        BLUE,
        WHITE;

    }

}
