package com.testingjava.test14;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class TestingSpliterator {

    public static void main(String[] args) {

        List<Double> al = new ArrayList<>();

        al.add(1.0);
        al.add(2.0);
        al.add(3.0);
        al.add(4.0);
        al.add(5.0);

        System.out.println(al);

        Spliterator<Double> splal = al.spliterator();

        while (splal.tryAdvance((n) -> System.out.print(n + " "))) ;

        System.out.println();

//      Первый способ

        List<Double> nal = new ArrayList<>();

        Spliterator<Double> splnal = al.spliterator();

        while (splnal.tryAdvance((n) -> nal.add(Math.sqrt(n))));

        System.out.println(nal);

//      Второй способ

        List<Double> nal2 = al;

        splnal = nal2.spliterator();

        while(splnal.tryAdvance((n) -> nal2.set(nal2.indexOf(n) ,Math.sqrt(n))));

        System.out.println(nal2);

        splnal = nal.spliterator();

        splnal.forEachRemaining((n) -> System.out.print(n + " "));

    }
}
