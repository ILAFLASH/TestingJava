package com.testingjava.test27;

import java.util.concurrent.Semaphore;

public class TestingSemaphore {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);

        Thread a = new Thread(new IncThread("A", sem));
        Thread b = new Thread(new DecThread("B", sem));
        a.start();
        b.start();
    }
}

// Общий ресурс
class Shared {
    static int count = 0;
}

// Поток исполнения, увеличиваюший значение счетчика на единицу
class IncThread implements Runnable {
    String name;
    Semaphore sem;

    public IncThread(String name, Semaphore sem) {
        this.name = name;
        this.sem = sem;
    }

    @Override
    public void run() {
        System.out.println("Запуск потока " + name);
        try {
            // сначала получить разрешение
            System.out.println("Поток " + name + " ожидает разрешения");
            sem.acquire();
            System.out.println("Поток " + name + " получает разрешение");
            // а теперь получить доступ к общему ресурсу
            for (int i = 0; i < 50 ; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);
                // разрешить, если возможно, переключение контекста
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        // освободить разрешение
        System.out.println("Поток " + name + " освобождает разрешение");
        sem.release();
    }
}

// Поток исполнения, уменьшаюший значение счетчика на единицу
class DecThread implements Runnable {
    String name;
    Semaphore sem;

    public DecThread(String name, Semaphore sem) {
        this.name = name;
        this.sem = sem;
    }

    @Override
    public void run() {
        System.out.println("Запуск потока " + name);
        try {
            // сначала получить разрешение
            System.out.println("Поток " + name + " ожидает разрешения");
            sem.acquire();
            System.out.println("Поток " + name + " получает разрешение");
            // а теперь получить доступ к общему ресурсу
            for (int i = 0; i < 50 ; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);
                // разрешить, если возможно, переключение контекста
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // освободить разрешение
        System.out.println("Поток " + name + " освобождает разрешение");
        sem.release();
    }
}
