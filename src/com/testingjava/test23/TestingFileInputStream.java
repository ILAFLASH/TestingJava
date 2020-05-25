package com.testingjava.test23;

import java.io.FileInputStream;
import java.io.IOException;

public class TestingFileInputStream {
    public static void main(String[] args) {
        int size;
        try (FileInputStream f = new FileInputStream("src/com/testingjava/test23/TestingFileInputStream.java")) {
            System.out.println("Общее количество доступных байтов: " + (size = f.available()));

            int n = size / 40;
            System.out.println("Первые " + n + " байтов, прочитанных из файла по очереди методом read()");
            for (int i = 0; i < n; i++) {
                System.out.print((char) f.read());
            }

            System.out.println("\nВсе еще доступно: " + f.available());

            System.out.println("Чтение следующих " + n + " байтов по очереди методом read(b[])");
            byte[] b = new byte[n];
            if (f.read(b) != 0) {
                System.err.println("Нельзя прочитать " + n + " байтов.");
            }

            System.out.println(new String(b, 0, n));

            System.out.println("\nBce еще доступно: " + (size = f.available()));

            System.out.println("Пропустить половину оставшихся байтов методом skip()");
            f.skip(size / 2);
            System.out.println("Bce еще доступно: " + f.available());

            System.out.println("Чтение " + n / 2 + " байтов, размещаемых в конце массива");
            if (f.read(b, n / 2, n / 2) != n / 2) {
                System.err.println("Нельзя прочитать" + n / 2 + "байтов.");
                System.out.println(new String(b, 0, b.length));
                System.out.println("\nBce еще доступно: " + f.available());
            }

        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}
