package com.testingjava.test42;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

public class TestingStreamIterator {
    public static void main(String[] args) {

        List<String> myList = new ArrayList<>();
        myList.add("Альфа");
        myList.add("Бета");
        myList.add("Гамма");
        myList.add("Дельта");
        myList.add("Кси");
        myList.add("Омега");

        // Используем итератор
        Stream<String> myStream = myList.stream();
        Iterator<String> itr = myStream.iterator();
        while (itr.hasNext()) System.out.println(itr.next());
        System.out.println();

        // Используем сплитератор
        myStream = myList.stream();
        Spliterator<String> splitItr = myStream.spliterator();
        while (splitItr.tryAdvance((n) -> System.out.println(n)));
        System.out.println();

        // Используем метод trySplit()
        myStream = myList.stream();
        // получить итератор - разделитель
        Spliterator<String> splitItr1 = myStream.spliterator();
        // получить итератор - разделитель
        Spliterator<String> splitItr2 = splitItr1.trySplit();
        // используем сначала итератор splitItr2, если нельзя разделить - итератор splitItr
        if (splitItr2 != null) {
            System.out.println("Результат, выводимый итератором splitItr2: ");
            splitItr2.forEachRemaining((n) -> System.out.println(n));
        }

        // а теперь воспользуемся итератором splitItr
        System.out.println();
        System.out.println("Результат, выводимый итератором splitItr: ");
        splitItr1.forEachRemaining(System.out::println);
    }
}
