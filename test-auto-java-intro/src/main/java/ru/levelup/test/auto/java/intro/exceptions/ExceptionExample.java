package ru.levelup.test.auto.java.intro.exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionExample {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        try {
            System.out.println("Start try");
            System.out.print("Enter the number: -> ");
            s = br.readLine();
            Integer i = Integer.parseInt(s);
            System.out.println("i -> " + i);
        } catch (IOException e) {
            System.out.println("Start catch");
            e.printStackTrace();
        } catch (Exception e) {

        }
        finally {
            System.out.println("Start finally");
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        System.out.println("Continue code");
        System.out.println(10 + 10);
    }

}
