package com.testingjava.test16;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class MyComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}

public class TestingComparator {
    public static void main(String[] args) {

//        Set<String> set = new TreeSet<>((o1, o2) -> o2.compareTo(o1));
        Set<String> set = new TreeSet<>(new MyComp());

        set.add("C");
        set.add("A");
        set.add("D");
        set.add("F");
        set.add("R");
        set.add("Y");

        for (String s: set) {
            System.out.print(s + " ");
        }
    }
}
