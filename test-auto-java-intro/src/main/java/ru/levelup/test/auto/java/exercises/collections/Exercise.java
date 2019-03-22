package ru.levelup.test.auto.java.exercises.collections;

import java.util.ArrayList;
import java.util.List;

public class Exercise {

    /**
     * 1. Создать класс товара (имя товара; стоимость товара)
     * 2. Создать список различных товаров не меньше 15
     * 3. Написать метод, который возвращает список товаров в заданном диапазоне цен
     * 4. Написать метод, которые возвращает список товаров стоимость, которых больше средней цены + 20
     * 5. Написать метод, которые возвращает имя товара по заданной цене.
     *      Если таких товаров несколько вернуть второй
     */

    public static void main(String[] args) {
        List<Sku> list = new ArrayList<>();
        list.add(new Sku("good 1", 76.98));
        list.add(new Sku("good 2", 0.95));
        list.add(new Sku("good 3", 7.68));
        list.add(new Sku("good 4", 56.0));
        list.add(new Sku("good 5", 12.98));
        list.add(new Sku("good 5", 54.33));
        list.add(new Sku("good 6", 4.96));
        list.add(new Sku("good 7", 3.14));
        list.add(new Sku("good 4", 15.92));
        list.add(new Sku("good 2", 17.00));
        list.add(new Sku("good 6", 2.0));
        list.add(new Sku("good 5", 3.98));
        list.add(new Sku("good 1", 76.98));
        list.add(new Sku("good 1", 23.98));
        list.add(new Sku("good 6", 32.32));
        list.add(new Sku("good 3", 76.76));

        System.out.println(getSkuInRange(list, 10, 20));
    }

    static List<Sku> getSkuInRange(List<Sku> inputData, double lowPrice, double highPrice) {
        List<Sku> results = new ArrayList<>();
        for (Sku item : inputData) {
            if(item.getPrice() < highPrice && item.getPrice() > lowPrice) {
                results.add(item);
            }
        }
        return results;
    }

}
