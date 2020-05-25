package com.testingjava.test41;

import java.util.*;
import java.util.stream.*;

// Использовать метод collect() для создания списка типа List и множества типа Set из потока данных
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

public class TestingToListToSet {
    public static void main(String[] args) {

        // Список имен, номеров телефонов и адресов электронной почты
        List<NamePhoneEmail> myList = new ArrayList<>();
        myList.add(new NamePhoneEmail("Ларри", "555-5555", "Larry@HerbSchildt.com"));
        myList.add(new NamePhoneEmail("Джeймc", "555-4444", "James@HerbSchildt.com"));
        myList.add(new NamePhoneEmail("Мэри", "555-3333", "Mary@HerbSchildt.com"));

        // отобразить только имена и номера телефонов на новый поток данных
        Stream<NamePhone> nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phonenum));

        // вызвать метод collect(), чтобы составить список типа List из имен и номеров телефонов
        List<NamePhone> npList = nameAndPhone.collect(Collectors.toList());
        System.out.println("Имена и номера телефонов в списке типа List: ");
        for (NamePhone e : npList) System.out.println(e.name + ": " + e.phonenum);
        System.out.println();

        // получить другое отображение имен и номеров телефонов
        // а теперь создать множество типа Set, вызвав метод collect()
        nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phonenum));
        Set<NamePhone> npSet = nameAndPhone.collect(Collectors.toSet());
        System.out.println("Имена и номера телефонов в множестве типа Set: ");
        for (NamePhone e : npSet) System.out.println(e.name + ": " + e.phonenum);
        System.out.println();

        // создание коллекции LinkedList
        System.out.println("Вывод коллекции LinkedList:");
        nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phonenum));
        LinkedList<NamePhone> npLinkedList = nameAndPhone.collect(() -> new LinkedList<>(),
                (list, element) -> list.add(element),
                (listA, listB) -> listA.addAll(listB));
        for (NamePhone np : npLinkedList) {
            System.out.println(np.name + " " + np.phonenum);
        }
        System.out.println();

        // создание коллекции HashSet
        System.out.println("Вывод коллекции HashSet:");
        nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phonenum));
        npSet = nameAndPhone.collect(HashSet::new, HashSet::add, HashSet::addAll);
        for (NamePhone np: npSet) {
            System.out.println(np.name + " " + np.phonenum);
        }
        System.out.println();
    }
}