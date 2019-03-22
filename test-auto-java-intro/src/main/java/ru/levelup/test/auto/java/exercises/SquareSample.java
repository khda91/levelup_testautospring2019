package ru.levelup.test.auto.java.exercises;

// Реализация решения квадратного уравнения
public class SquareSample {

    public static void main(String[] args) {
        double a1 = 0.1;
        double b1 = -5.0;
        double c1 = -2.0;

        evaluation(a1, b1, c1);

        double a2 = 100.000000001;
        double b2 = 0.8761516262;
        double c2 = -672.0;

        evaluation(a2, b2, c2);
    }

    double discriminantEvaluation(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    static void evaluation(double a, double b, double c) {
        SquareSample ss = new SquareSample();

        double discriminant = ss.discriminantEvaluation(a, b, c);

        if (discriminant > 0.0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println(String.format("x1 = %s, x2 = %s", x1, x2));
        } else if (discriminant == 0.0) {
            System.out.println("x1 = x2 = " + (-b / (2 * a)));
        } else {
            System.out.println("solution was not found");
        }
    }
}
