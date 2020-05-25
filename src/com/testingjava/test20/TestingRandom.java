package com.testingjava.test20;

import java.util.Random;

public class TestingRandom {
    public static void main(String[] args) {
        Random r = new Random();
        double valG;
        double sum = 0;
        int[] bell = new int[10];

        for (int i = 0; i < 100; i++) {
            valG = r.nextGaussian();
            sum += valG;
            double t = -2;

            for (int j = 0; j < 10; j++, t += 0.5) {
                if (valG < t) {
                    bell[j]++;
                    break;
                }
            }
        }

        System.out.println("Среднее всех значений: " + (sum / 100));
        for (int i = 0; i < 10; i++) {
            for (int j = bell[i]; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
