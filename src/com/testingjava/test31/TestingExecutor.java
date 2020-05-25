package com.testingjava.test31;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestingExecutor {
    public static void main(String[] args) {

        CountDownLatch cd1 = new CountDownLatch(5);
        CountDownLatch cd2 = new CountDownLatch(5);
        CountDownLatch cd3 = new CountDownLatch(5);
        CountDownLatch cd4 = new CountDownLatch(5);

        ExecutorService service = Executors.newFixedThreadPool(2);

        System.out.println("Запуск потоков");

        service.execute(new MyThread(cd1, "A"));
        service.execute(new MyThread(cd2, "B"));
        service.execute(new MyThread(cd3, "C"));
        service.execute(new MyThread(cd4, "D"));

        try {
            cd1.await();
            cd2.await();
            cd3.await();
            cd4.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        service.shutdown();
        System.out.println("Завершение потоков");
    }
}

class MyThread implements Runnable {
    CountDownLatch latch;
    String name;

    public MyThread(CountDownLatch latch, String name) {
        this.latch = latch;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            latch.countDown();
        }
    }
}
