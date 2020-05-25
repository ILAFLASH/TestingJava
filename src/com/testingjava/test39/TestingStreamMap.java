package com.testingjava.test39;

// Применить метод map() для создания нового потока данных, содержащего только избранные
// элементы из исходного потока

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class NamePhoneEmail {
    String name;
    String phonenum;
    String email;

    public NamePhoneEmail(String name, String phonenum, String email) {
        this.name = name;
        this.phonenum = phonenum;
        this.email = email;
    }
}

class NamePhone {
    String name;
    String phonenum;

    public NamePhone(String name, String phonenum) {
        this.name = name;
        this.phonenum = phonenum;
    }
}

public class TestingStreamMap {
    public static void main(String[] args) {
        // Список имен, номеров телефонов и адресов электронной почты
        List<NamePhoneEmail> myList = new ArrayList<>();
        myList.add(new NamePhoneEmail("Ларри", "555-5555", "larry@herbschiltd.com"));
        myList.add(new NamePhoneEmail("Джеймс", "555-4444", "james@herbschiltd.com"));
        myList.add(new NamePhoneEmail("Мэри", "555-3333", "mary@herbschiltd.com"));

        System.out.println("Исходные элементы из списка myList: ");
        myList.stream().forEach((a) -> System.out.println(a.name + " " + a.phonenum + " " + a.email));
        System.out.println();

        // отобразить на новый поток данных только имена и номера телефонов
        Stream<NamePhone> nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phonenum));
        System.out.println("Список имен и номеров телефонов: ");
        nameAndPhone.forEach((a) -> System.out.println(a.name + " " + a.phonenum));
        System.out.println();

        // только имена и номера телефонов с именем Джеймс
        System.out.println("Список имен и номеров телефонов с именем Джеймс: ");
        myList.stream().filter((a) -> a.name == "Джеймс")
                .map((a) -> (new NamePhone(a.name, a.phonenum)))
                .forEach((a) -> System.out.println(a.name + " " + a.phonenum));
    }
}
