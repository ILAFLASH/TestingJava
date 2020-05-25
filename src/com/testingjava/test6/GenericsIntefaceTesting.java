package com.testingjava.test6;

interface MinMax<T extends Comparable<T>> {
    T min();
    T max();
}

class MyClass<T extends Comparable<T>> implements MinMax<T> {
    T[] vals;

    public MyClass(T[] vals) {
        this.vals = vals;
    }

    @Override
    public T min() {
        T min = vals[0];
        for (int i = 1; i < vals.length; i++) {
            if (vals[i].compareTo(min) < 0) min = vals[i];
        }
        return min;
    }

    @Override
    public T max() {
        T max = vals[0];
        for (int i = 1; i < vals.length; i++) {
            if (vals[i].compareTo(max) > 0) max = vals[i];
        }
        return max;
    }
}

public class GenericsIntefaceTesting {
    public static void main(String[] args) {
        Character[] characters = {'f', 'a', 'r', 'k', 't'};

        MyClass myClass1 = new MyClass(characters);

        System.out.println(myClass1.min());
        System.out.println(myClass1.max());

        Integer[] integers = {5,7,3,4,9,2};

        MyClass myClass2 = new MyClass(integers);

        System.out.println(myClass2.min());
        System.out.println(myClass2.max());
    }
}
