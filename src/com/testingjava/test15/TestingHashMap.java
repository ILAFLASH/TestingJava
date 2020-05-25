package com.testingjava.test15;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TestingHashMap {
    public static void main(String[] args) {

        Map<String, Double> hm = new TreeMap<>();

        hm.put("Джон Доу", new Double(3434.34));
        hm.put("Том Смит", new Double(123.12));
        hm.put("Джейн Бейкер", new Double(1378.00));
        hm.put("Тод Холл", new Double(99.22));
        hm.put("Ральф Смит", new Double(-19.08));

        Set<Map.Entry<String, Double>> set = hm.entrySet();

        for (Map.Entry<String, Double> me: set) {
            System.out.println(me.getKey() + ": " + me.getValue());
        }

        double balance = hm.get("Том Смит");
        hm.put("Том Смит", balance + 1000);

        System.out.println();

        for (Map.Entry<String, Double> me: set) {
            System.out.println(me.getKey() + ": " + me.getValue());
        }
    }
}
