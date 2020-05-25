package com.testingjava.test12;

public class TestingString {
    static String arr[] = {"Now", "is", "the", "time", "for", "all", "good", "men", "to",
            "come", "to", "the", "aid", "of", "their", "country"};

    public static void main(String[] args) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].compareToIgnoreCase(arr[j]) > 0) {
                    String t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
            System.out.println(arr[i]);
        }

        StringBuffer sb = new StringBuffer("Это простой тест.");
        sb.replace(4, 11, "был");
        System.out.println(sb);

        System.out.println(Integer.MIN_VALUE + " " + Integer.MAX_VALUE);

        System.out.println(Character.MIN_VALUE + " " + Character.MAX_VALUE);

        Class c = void.class;
        System.out.println(c);
    }
}
