package com.testingjava.test4;

class Gen<A extends Number> {
    private A[] numbers;

    public Gen(A[] numbers) {
        this.numbers = numbers;
    }

    public double average() {
        double sum = 0.0;

        for (A number : numbers) {
            sum += number.doubleValue();
        }

        return sum / numbers.length;
    }

    public boolean sameAverage(Gen<?> numbers) {
        return this.average() == numbers.average();
    }
}

public class GenericsTesting {
    public static void main(String[] args) {
        Gen<Integer> integerGen = new Gen<>(new Integer[]{1, 2, 3, 4, 5});
        System.out.println(integerGen.average());

        Gen<Float> floatGen = new Gen<>(new Float[]{1f, 2f, 3f, 4f, 5f});
        System.out.println(floatGen.average());

        System.out.println(integerGen.sameAverage(floatGen));
    }
}
