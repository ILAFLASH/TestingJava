package com.testingjava.test37;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TestingStream {
    public static void main(String[] args) {
        // создать списочный массив значений типа Integer
        List<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        System.out.println("Исходный список: " + myList);

        // получить поток элементов списочного массива
        Stream<Integer> myStream = myList.stream();

        // получить минимальное и максимальное значения
        Optional<Integer> minVal = myStream.min(Integer::compare);
        if (minVal.isPresent()) System.out.println("Минимальное значение: " + minVal.get());

        // непременно получить новый поток данных, поскольку предыдущий вызов метода min()
        // стал конечной операцией, употребившей поток данных
        myStream = myList.stream();
        Optional<Integer> maxVal = myStream.max(Integer::compare);
        if (maxVal.isPresent()) System.out.println("Максимальное значение: " + maxVal.get());

        // отсортировать поток данных, вызвав метод sorted()
        Stream<Integer> sortedStream = myList.stream().sorted();

        // Отобразить отсортированный поток данных
        System.out.print("Отсортированный поток данных: ");
        sortedStream.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        // вывести только нечетный целочисленные значения
        Stream<Integer> oddVals = myList.stream().sorted().filter((n) -> (n % 2) == 1);
        System.out.print("Нечетные значения: ");
        oddVals.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        // вывести только те нечетные целочисленные значения, которые больше 5.
        oddVals = myList.stream().filter((n) -> (n % 2) == 1 && n > 5);
        System.out.print("Нечетные значения больше 5: ");
        oddVals.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        // Два способа получения результата перемножения целочисленных элементов списка с помощью reduce()
        Optional<Integer> productObj = myList.stream().reduce((a, b) -> a * b);
        if (productObj.isPresent()) System.out.println("Произведение в виде объекта типа Optional: " + productObj.get());

        int product = myList.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Произведение в виде объекта типа int: " + product);

        // Произведение только четных чисел
        int evenProduct = myList.stream().reduce(1, (a, b) -> {if (b % 2 ==0) return a * b; else return a;});
        System.out.println("Произведение четных чисел: " + evenProduct);

        // Параллельное выполнение перемножения целочисленных элементов списка с помощью reduce()
        Optional<Integer> productParallel = myList.parallelStream().reduce((a, b) -> a * b);
        if (productObj.isPresent()) System.out.println("Произведение в виде объекта типа Optional: " + productObj.get());

        // Еще один вариант параллельного выполнения перемножения целочисленных элементов списка с помощью reduce()
        int parallelProduct = myList.parallelStream().reduce(1, (a, b) -> a * b, (a, b) -> a * b);
        System.out.println("Произведение в виде объекта типа Optional: " + parallelProduct);
     }
}
