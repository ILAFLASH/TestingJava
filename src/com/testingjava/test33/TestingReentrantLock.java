package com.testingjava.test33;

import java.util.concurrent.locks.ReentrantLock;

public class TestingReentrantLock {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        Thread a = new Thread(new LockThread("A", lock));
        Thread b = new Thread(new LockThread("B", lock));

        a.start();
        b.start();
    }
}

// Общий ресурс
class Shared {
    static int count = 0;
}

// Поток исполнения, инкрементирующий значение счетчика
class LockThread implements Runnable {
    String name;
    ReentrantLock lock;

    public LockThread(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        // сначала заблокировать счетчик
        System.out.println("Поток "+ name + " ожидает блокировки счетчика");
        lock.lock();
        System.out.println("Поток "+ name + " блокирует счетчик.");
        Shared.count++;
        System.out.println("Поток " + name + ": " + Shared.count);
        // а теперь переключить контекст, если это возможно
        System.out.println("Поток " + name + " ожидает");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);;
        } finally {
            // снять блокировку
            System.out.println("Поток " + name + " разблокирует счетчик");
            lock.unlock();
        }
    }
}
