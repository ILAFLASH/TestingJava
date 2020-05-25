package com.testingjava.test43;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TestingRegex {
    public static void main(String[] args) {
        Pattern pattern;
        Matcher matcher;
        boolean found;

        // Первый пример
        pattern = Pattern.compile("Java");
        matcher = pattern.matcher("Java");
        found = matcher.matches(); // Проверить совпадение
        System.out.print("Проверка совпадениея Java с Java: ");
        if (found) System.out.println("Совпадает");
        else System.out.println("Не совпадает");
        System.out.println();

        // Второй пример
        System.out.print("Проверка совпадения Java с Java 9: ");
        matcher = pattern.matcher("Java 9"); //создать новый сопоставитель с шаблоном
        found = matcher.matches(); // проверить на совпадение
        if(found) System.out.println("Совпадает");
        else System.out.println("He совпадает");
        System.out.println();

        // Третий пример
        System.out.print("Поиск Java в Java 9: ");
        if (matcher.find()) System.out.println("Подпоследовательность найдена");
        else System.out.println("Подпоследовательность не найдена");
        System.out.println();

        // Четвертый пример
        pattern = Pattern.compile("test");
        matcher = pattern.matcher("test 1 2 3 test");
        while (matcher.find()) System.out.println("Подпоследовательность test найдена по индексу " + matcher.start());
        System.out.println();

        // Пятый пример
        pattern = Pattern.compile("W+");
        matcher = pattern.matcher("W WW WWW");
        while (matcher.find()) System.out.println("Совпадение: " + matcher.group());
        System.out.println();

        // Шестой пример
        pattern = Pattern.compile("e.+d");
        matcher = pattern.matcher("extend cup end table");
        while (matcher.find()) System.out.println("Совпадение: " + matcher.group());
        System.out.println();

        // Седьмой пример
        pattern = Pattern.compile("e.+?d");
        matcher = pattern.matcher("extend cup end table");
        while (matcher.find()) System.out.println("Совпадение: " + matcher.group());
        System.out.println();

        // Восьмой пример
        pattern = Pattern.compile("e.?+d");
        matcher = pattern.matcher("extend cup end table");
        while (matcher.find()) System.out.println("Совпадение: " + matcher.group());
        System.out.println();

        // Девятый пример
        pattern = Pattern.compile("[a-z]+");
        matcher = pattern.matcher("this is a test.");
        while (matcher.find()) System.out.println("Совпадение: " + matcher.group());
        System.out.println();

        // Десятый пример
        String str = "John Johnathan Frank Ken Todd";
        pattern = Pattern.compile("John.*? ");
        matcher = pattern.matcher(str);
        System.out.println("Исходная послеловатеоьномть: " + str);
        str = matcher.replaceAll("Eric ");
        System.out.println("Измененная последовательность: " + str);
        System.out.println();

        // Одиннадцатый пример
        pattern = Pattern.compile("[ ,.!]+");
        String[] strings = pattern.split("one two, alpha9 12!done.");
        for (int i = 0; i < strings.length ; i++) {
            System.out.println("Следующая лексема: " + strings[i]);
        }
        System.out.println();

        // Просто тестировал
        System.out.println("string".matches("string"));
    }
}
