package com.temptesting.test2;

import java.util.List;

import static java.util.Arrays.sort;

public class StreamApiDemo {
    public static void main(String[] args) {
        // Получаем список двумя разными подходами
//        List<Specialist> specialists = OldApproachUtil.getSpecialists();
        List<Specialist> specialists = StreamApiUtil.getSpecialists();

        // Фильтр по специальности
//        List<Specialist> engineers = OldApproachUtil.filterBySpeciality(specialists, Speciality.ENGINEER);
//        List<Specialist> engineers = StreamApiUtil.filterBySpeciality(specialists, Speciality.ENGINEER);
//        StreamApiUtil.printSpecialists(engineers);

        // Сортировка
//        List<Specialist> sortedSpecialistAsc = StreamApiUtil.sortedSpecialistAsc(specialists);
//        StreamApiUtil.printSpecialists(sortedSpecialistAsc);
//        List<Specialist> sortedSpecialistDesc = StreamApiUtil.sortedSpecialistDesc(specialists);
//        StreamApiUtil.printSpecialists(sortedSpecialistDesc);

        // Минимальная зарплата
//        Specialist minSalarySpecialist = StreamApiUtil.minSalary(specialists);
//        StreamApiUtil.printSpecialists(asList(minSalarySpecialist));

        // Максимальная зарплата
//        Specialist maxSalarySpecialist = StreamApiUtil.maxSalary(specialists);
//        StreamApiUtil.printSpecialists(asList(maxSalarySpecialist));

        // Использование группировок
//        Map<Speciality, List<Specialist>> groupedBySpeciality = StreamApiUtil.groupBySpeciality(specialists);
//        System.out.println(groupedBySpeciality);;

        // Проверка, что все специалисты являются инженерами
//        boolean allEngineers = StreamApiUtil.allEngineers(specialists);
//        System.out.println(allEngineers);

        // Проверка, что хотя бы один специалист является инженером
//        boolean anyEngineers = StreamApiUtil.anyEngineers(specialists);
//        System.out.println(anyEngineers);

        // Проверка у кого зарплата больше 10000
        boolean noOneWithSalaryMoreThen10000 = StreamApiUtil.noOneWithSalaryMoreThen10000(specialists);
        System.out.println(noOneWithSalaryMoreThen10000);
    }
}
