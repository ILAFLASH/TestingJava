package com.temptesting.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

class Human {
    private String name;
    private List<String> pets;

    public Human(String name, List<String> pets) {
        this.name = name;
        this.pets = pets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPets() {
        return pets;
    }

    public void setPets(List<String> pets) {
        this.pets = pets;
    }
}

public class TestingFlatMap {
    public static void main(String[] args) {
        List<Human> humans = asList(new Human("Sam", asList("Buddy", "Lucy")),
                new Human("Bob", asList("Frankie", "Rosie")),
                new Human("Marta", asList("Simba", "Tilly")));

        // С помощью коллекции
        List<String> petNames = new ArrayList<>();

        for (Human human: humans) {
            petNames.addAll(human.getPets());
        }

        System.out.println("Имена всех животных:");
        System.out.println(petNames);
        System.out.println();

        // С помощью flatmap()

        petNames = humans.stream()
//                .map(human -> human.getPets())    // преобразовываем Stream<Human> в Stream<List<Pet>>
//                .flatMap(pets -> pets.stream())   // "разворачиваем" Stream<List<Pet>> в Stream<Pet>
                .flatMap(human -> human.getPets().stream()) // сокращенная форма
                .collect(Collectors.toList());

        System.out.println("Имена всех животных:");
        System.out.println(petNames);
        System.out.println();
    }
}
