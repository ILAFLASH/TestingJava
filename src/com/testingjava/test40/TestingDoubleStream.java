package com.testingjava.test40;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TestingDoubleStream {
    public static void main(String[] args) {
        // Список значений типа Double
        List<Double> myList = new ArrayList<>();

        myList.add(1.1);
        myList.add(3.6);
        myList.add(9.2);
        myList.add(4.7);
        myList.add(12.1);
        myList.add(5.0);

        System.out.print("Исходные значений из списка myList: ");
        myList.stream().forEach((a) -> System.out.print(a + " "));
        System.out.println();

        // Отобразить максимально допустимый преде каждого значения из списка myList на поток данных типа IntStream
        IntStream cStrm = myList.stream().mapToInt((a) -> (int) Math.ceil(a));
        System.out.print("Максимально допустимые пределы значений из списка myList: ");
        cStrm.forEach((a) -> System.out.print(a + " "));
        System.out.println();
    }
}
