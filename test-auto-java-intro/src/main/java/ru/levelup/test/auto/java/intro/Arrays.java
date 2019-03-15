package ru.levelup.test.auto.java.intro;

import java.util.ArrayList;
import java.util.HashMap;

public class Arrays {

    public static void main(String[] args) {

        String[][] doubleArray = {
                {"mama", "papa", "baba"},
                {"1", "2", "3", "4"},
                {"casca", "sdasda"}
        };

        Object[][] obj = {
                {"dsdasd", 2.0, 1},
                {0.9f, false, new Arrays(), new ArrayList<>()},
                {8L, new HashMap<String, Object>()}
        };

        // get row from double array
        Object[] m = obj[2];  // m = {8L, new HashMap<String, Object>()}

        // get two rows
        Object[][] twoRowsFromArray = new Object[2][];
        twoRowsFromArray[0] = obj[0];
        twoRowsFromArray[1] = obj[2];

        /*
            Object[][] twoRowsFromArray = {
                {"dsdasd", 2.0, 1},
                {8L, new HashMap<String, Object>()}
        }
         */

        // get element from doubel array
        Object n = obj[1][3]; // n = new ArrayList<>()

        // Init double array
        String[][] strs = new String[10][6];

        // four array
        String[][][][] strss = new String[10][6][4][2];

    }

}
