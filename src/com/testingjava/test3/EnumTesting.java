package com.testingjava.test3;

public class EnumTesting {
    public static void main(String[] args) {
        for (AppleEnum a: AppleEnum.values()) {
            System.out.println(a + " " + a.getPrice());
        }

        Character character = Character.valueOf('\u0243');
        Character character2 = '\u024f';
        Class c = character.getClass();

        System.out.println(character.charValue());
        System.out.println(character2);
        System.out.println(character.getClass());
        System.out.println(c.getName());
    }
}
