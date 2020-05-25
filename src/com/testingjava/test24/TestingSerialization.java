package com.testingjava.test24;

import java.io.*;

public class TestingSerialization {
    public static void main(String[] args) {

        // произвести сериализацию объекта
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/com/testingjava/test24/serial"))){
            MyClass myClass1 = new MyClass("Hello", -7, 2.7e10);
            System.out.println("myClass1: " + myClass1);
            objectOutputStream.writeObject(myClass1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // произвести десериализацию объекта

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/com/testingjava/test24/serial"))) {
            MyClass myClass2 = (MyClass) objectInputStream.readObject();
            System.out.println("myClass2: " + myClass2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
