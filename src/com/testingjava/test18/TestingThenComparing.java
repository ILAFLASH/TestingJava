package com.testingjava.test18;

import java.util.*;

class LastNameComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String s1, s2;
        s1 = o1.substring(o1.indexOf(' '));
        s2 = o2.substring(o2.indexOf(' '));
        return s1.compareTo(s2);
    }
}

class FirstNameComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}

public class TestingThenComparing {

    public static void main(String[] args) {

//        LastNameComp lastNameComp = new LastNameComp();
//        FirstNameComp firstNameComp = new FirstNameComp();
//        Map<String, Double> tm = new TreeMap<>(lastNameComp.thenComparing(firstNameComp));

        Map<String, Double> tm = new TreeMap<>((o1, o2) -> {
            String s1, s2;
            s1 = o1.substring(o1.indexOf(' '));
            s2 = o2.substring(o2.indexOf(' '));
            return s1.compareTo(s2) != 0 ? s1.compareTo(s2) : o1.compareTo(o2);
        });

        tm.put("Ральф Смит", new Double(-19.08));
        tm.put("Том Смит", new Double(123.12));
        tm.put("Джейн Бейкер", new Double(1378.00));
        tm.put("Джон Доу", new Double(3434.34));
        tm.put("Тод Холл", new Double(99.22));

        Set<Map.Entry<String, Double>> set = tm.entrySet();

        for (Map.Entry<String, Double> s : set) {
            System.out.println(s);
        }
    }


}
