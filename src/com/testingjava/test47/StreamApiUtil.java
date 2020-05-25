package com.temptesting.test2;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApiUtil {
    // Получение начального списка специалистов
    public static List<Specialist> getSpecialists() {
        return List.of(
                new Specialist("Ivan Ivanov", new BigDecimal(5000), Speciality.ENGINEER),
                new Specialist("Alexandr Alexandrov", new BigDecimal(4000), Speciality.ENGINEER),
                new Specialist("Sergey Setgeev", new BigDecimal(3000), Speciality.DEVOPS),
                new Specialist("Fedor Fedorov", new BigDecimal(2000), Speciality.DEVOPS),
                new Specialist("Kirill Kirillov", new BigDecimal(10000), Speciality.MANAGER),
                new Specialist("Petr Petrov", new BigDecimal(10000), Speciality.MANAGER)
        );
    }

    // Поиск по специальности
    public static List<Specialist> filterBySpeciality(List<Specialist> specialists, Speciality speciality) {
        return specialists.stream()
                .filter(specialist -> specialist.getSpeciality().equals(speciality))
                .collect(Collectors.toList());
    }

    // Сортировка по возрастанию
    public static List<Specialist> sortedSpecialistAsc(List<Specialist> specialists) {
        return specialists.stream()
                .sorted(Comparator.comparing(Specialist::getName))
                .collect(Collectors.toList());
    }

    // Сортировка по убыванию
    public static List<Specialist> sortedSpecialistDesc(List<Specialist> specialists) {
        return specialists.stream()
                .sorted(Comparator.comparing(Specialist::getName).reversed())
                .collect(Collectors.toList());
    }

    // Минимальная зарплата
    public static Specialist minSalary(List<Specialist> specialists) {
        return specialists.stream()
                .min(Comparator.comparing(Specialist::getSalary))
                .orElse(null);
    }

    // Максимальная зарплата
    public static Specialist maxSalary(List<Specialist> specialists) {
        return specialists.stream()
                .max(Comparator.comparing(Specialist::getSalary))
                .orElse(null);
    }

    // Группировка по специалистов по специальности
    public static Map<Speciality, List<Specialist>> groupBySpeciality(List<Specialist> specialists) {
        return specialists.stream()
                .collect(Collectors.groupingBy(Specialist::getSpeciality));
    }

    // Проверка, что все специалисты являются инженерами
    public static boolean allEngineers(List<Specialist> specialists) {
        return specialists.stream().allMatch(specialist -> specialist.getSpeciality().equals(Speciality.ENGINEER));
    }

    // Проверка, что хотя бы один специалист является инженером
    public static boolean anyEngineers(List<Specialist> specialists) {
        return specialists.stream().anyMatch(specialist -> specialist.getSpeciality().equals(Speciality.ENGINEER));
    }

    // Проверка у кого зарплата больше 10000
    public static boolean noOneWithSalaryMoreThen10000(List<Specialist> specialists) {
        return specialists.stream().noneMatch(specialist -> specialist.getSalary().compareTo(new BigDecimal(10000)) > 0);
    }

    // Вывод на экран
    public static void printSpecialists(List<Specialist> specialists) {
        System.out.println();
        System.out.println("Список сотрудников:");
        for (Specialist specialist : specialists) {
            System.out.println("Имя и фамилия: " + specialist.getName() + " Зарплата: " + specialist.getSalary() + " Специальность: " + specialist.getSpeciality());
        }
    }
}
