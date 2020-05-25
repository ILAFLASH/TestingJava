package com.temptesting.test2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OldApproachUtil {
    // Получение начального списка специалистов
    public static List<Specialist> getSpecialists() {
        List<Specialist> result = new ArrayList<>();
        result.add(new Specialist("Ivan Ivanov", new BigDecimal(5000), Speciality.ENGINEER));
        result.add(new Specialist("Alexandr Alexandrov", new BigDecimal(4000), Speciality.ENGINEER));
        result.add(new Specialist("Sergey Setgeev", new BigDecimal(3000), Speciality.DEVOPS));
        result.add(new Specialist("Fedor Fedorov", new BigDecimal(2000), Speciality.DEVOPS));
        result.add(new Specialist("Kirill Kirillov", new BigDecimal(10000), Speciality.MANAGER));
        result.add(new Specialist("Petr Petrov", new BigDecimal(10000), Speciality.MANAGER));
        return result;
    }

    // Поиск по специальности
    public static List<Specialist> filterBySpeciality(List<Specialist> specialists, Speciality speciality) {
        List<Specialist> result = new ArrayList<>();
        for (int i = 0; i < specialists.size(); i++) {
            if (specialists.get(i).getSpeciality().equals(speciality)) {
                result.add(specialists.get(i));
            }
        }
        return result;
    }
}
