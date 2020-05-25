package com.testingjava.test17;

import java.util.*;

class TComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String s1, s2;
        int i;
        s1 = o1.substring(o1.indexOf(' '));
        s2 = o2.substring(o2.indexOf(' '));
        if (s1.compareTo(s2) == 0) {
            return o1.compareTo(o2);
        }
        return s1.compareTo(s2);
    }
}

public class TestingComparatorAdvanced {
    public static void main(String[] args) {
//        Map<String, Double> treeMap = new TreeMap<>(new TComp());

        Map<String, Double> treeMap = new TreeMap<>(((o1, o2) -> {
            String s1, s2;
            int i;
            s1 = o1.substring(o1.indexOf(' '));
            s2 = o2.substring(o2.indexOf(' '));
            if (s1.compareTo(s2) == 0) {
                return o1.compareTo(o2);
            }
            return s1.compareTo(s2);
        }));

        treeMap.put("Том Смит", new Double(123.12));
        treeMap.put("Джейн Бейкер", new Double(1378.00));
        treeMap.put("Джон Доу", new Double(3434.34));
        treeMap.put("Тод Холл", new Double(99.22));
        treeMap.put("Ральф Смит", new Double(-19.08));

        Set<Map.Entry<String, Double>> set = treeMap.entrySet();

        for (Map.Entry<String, Double> s : set) {
            System.out.println(s);
        }
    }
}
