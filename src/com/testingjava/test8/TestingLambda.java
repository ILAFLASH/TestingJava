package com.testingjava.test8;

interface NumericTest {
    boolean test(int n);
}

interface NumericFunc {
    int func(int n);
}

interface StringFunc {
    String func(String s);
}

interface Unified<T> {
    T um(T t);
}

public class TestingLambda {
    public static void main(String[] args) {
        NumericTest isEven = (n) -> (n % 2 == 0);

        if (isEven.test(10)) System.out.println("Число 10 четное");

        if (!isEven.test(9)) System.out.println("Число 9 нечетное");

        NumericTest isNonNeg = (n) -> (n > 0);

        if (isNonNeg.test(10)) System.out.println("Число 10 положительное");

        if (!isNonNeg.test(-10)) System.out.println("Число -10 отрицательное");

        NumericFunc factorial = (n) -> {
            int result = 1;

            for (int i = 1; i <= n ; i++) {
                result *= i;
            }

            return result;
        };

        System.out.println(factorial.func(3));
        System.out.println(factorial.func(5));

        StringFunc reverseString = (s) -> {
            String reverse = "";
            for (int i = s.length() - 1; i >= 0 ; i--) {
                reverse += s.charAt(i);
            }
            return reverse;
        };

        System.out.println(reverseString.func("Привет"));
        System.out.println(reverseString.func("Тринитротолуол"));

        Unified<Integer> factorialU = (t) -> {
            int result = 1;

            for (int i = 1; i <= t ; i++) {
                result *= i;
            }

            return result;
        };

        Unified<String> reverseStringUnified = (t) -> {
            String reverse = "";
            for (int i = t.length() - 1; i >= 0 ; i--) {
                reverse += t.charAt(i);
            }
            return reverse;
        };

        System.out.println(factorialU.um(3));
        System.out.println(factorialU.um(5));

        System.out.println(reverseStringUnified.um("Привет"));
        System.out.println(reverseStringUnified.um("Тринитротолуол"));
    }
}
