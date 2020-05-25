package com.testingjava.test38;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// Демонстрация применения объединяющей формы метода reduce()
public class TestingParallelStream {
    public static void main(String[] args) {
        List<Double> myList = new ArrayList<>();

        myList.add(7.0);
        myList.add(18.0);
        myList.add(10.0);
        myList.add(24.0);
        myList.add(17.0);
        myList.add(5.0);

        List<Double> myNewList = new ArrayList<>();

        myNewList.add(4.0);
        myNewList.add(9.0);
        myNewList.add(16.0);
        myNewList.add(25.0);

        // Произведение квадратных корней
        double productOfSqrRoots = myList.parallelStream().reduce(1.0, (a, b) -> a * Math.sqrt(b), (a, b) -> a * b);
        System.out.println("Произведение квадратных корней: " + productOfSqrRoots);

        // Произведение квадратных корней последовательно
        double productOfSqrt = myNewList.stream().reduce(1.0, (a, b) -> a * Math.sqrt(b));
        System.out.println("Произведение квадратных корней: " + productOfSqrt);

        // Произведение квадратных корней параллельно
        productOfSqrt = myNewList.parallelStream().reduce(1.0, (a, b) -> a * Math.sqrt(b), (a, b) -> a * b);
        System.out.println("Произведение квадратных корней: " + productOfSqrt);

        // Произведение квадратных корней с помощью map()
        Stream<Double> sqrtStream = myNewList.stream().map((a) -> Math.sqrt(a));
        productOfSqrt = sqrtStream.reduce(1.0, (a, b) -> a * b);
        System.out.println("Произведение квадратных корней: " + productOfSqrt);
    }
}
