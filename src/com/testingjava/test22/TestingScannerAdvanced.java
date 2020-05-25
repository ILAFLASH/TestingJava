package com.testingjava.test22;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class TestingScannerAdvanced {
    public static void main(String[] args) throws IOException {
        int count = 0;
        double sum = 0;

        FileWriter fout = new FileWriter("src/com/testingjava/test22/ScannerTest.txt");
        fout.write("2, 3.4, 5,6, 7.4, 9.1, 10.5, готово");
        fout.close();

        FileReader fin = new FileReader("src/com/testingjava/test22/ScannerTest.txt");
        Scanner sc = new Scanner(fin);
        sc.useLocale(Locale.US);
        sc.useDelimiter(", *");
        while (sc.hasNext()) {
            if (sc.hasNextDouble()) {
                sum += sc.nextDouble();
                count++;
            } else {
                String str = sc.next();
                if (str.equals("готово")) break;
                else {
                    System.out.println("Неверный формат файла.");
                    return;
                }
            }
        }
        sc.close();
        System.out.println("Среднее равно " + (sum / count));
    }
}
