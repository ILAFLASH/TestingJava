package com.testingjava.test21;

import java.util.Scanner;

public class TestingScanner {
    public static void main(String[] args) {

        int sum = 0;
        int amount = 0;
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            sum += sc.nextInt();
            amount++;
        }

        System.out.println(sum / amount);
    }
}
