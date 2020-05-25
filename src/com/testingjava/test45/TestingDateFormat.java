package com.testingjava.test45;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestingDateFormat {
    public static void main(String[] args) {
        Date date = new Date();
        DateFormat df;

        // Пример дат
        df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.JAPAN);
        System.out.println("Япония: " + df.format(date));

        df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.KOREA);
        System.out.println("Корея: " + df.format(date));

        df = DateFormat.getDateInstance(DateFormat.LONG, Locale.UK);
        System.out.println("Великобритания: " + df.format(date));

        df = DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
        System.out.println("CШA: " + df.format(date));

        System.out.println();

        // Пример времени
        df = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.JAPAN);
        System.out.println("Япония: " + df .format(date));

        df = DateFormat.getTimeInstance(DateFormat.LONG, Locale.UK);
        System.out.println("Великобритания: " + df.format(date) );

        df = DateFormat.getTimeInstance(DateFormat.FULL, Locale.CANADA);
        System.out.println("Канада: " + df.format(date));

        System.out.println();

        // SimpleDateFormat
        SimpleDateFormat sdf;

        sdf = new SimpleDateFormat("hh:mm:ss");
        System.out.println(sdf.format(date));

        sdf = new SimpleDateFormat("dd MMM yyyy hh:mm:ss zzz");
        System.out.println(sdf.format(date));

        sdf = new SimpleDateFormat("E MMM dd yyyy");
        System.out.println(sdf.format(date));

    }
}
