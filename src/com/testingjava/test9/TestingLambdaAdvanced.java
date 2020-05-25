package com.testingjava.test9;

interface StringFunc {
    String func(String n);
}

public class TestingLambdaAdvanced {

    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {

        String inStr = "Лямбда-выражения повышают эффективность Java";

        System.out.println("Это исходная строка: " + inStr);

        String outStr;

        outStr = stringOp((str) -> str.toUpperCase(), inStr);

        System.out.println("Это строка прописными буквами: " + outStr);

        outStr = stringOp((str) -> {
            String result = "";
            for (int i = 0; i < str.length() ; i++) {
                if (str.charAt(i) != ' ') result += str.charAt(i);
            }
            return result;
        } , inStr);

        System.out.println("Это строка без пробелов: " + outStr);
    }

}
