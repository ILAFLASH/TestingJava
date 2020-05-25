package com.testingjava.test29;

import java.util.concurrent.CountDownLatch;

public class TestingCountDownLatch {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);

        System.out.println("Запуск потока исполнения");

        new Thread(new MyThread(cdl)).start();

        try {
            cdl.await();
        } catch (InterruptedException e) {
            System.out.println(e);;
        }
        System.out.println("Завершение потока исполнения");
    }
}

class MyThread implements Runnable {
    CountDownLatch latch;

    public MyThread(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5 ; i++) {
            System.out.println(i);
            latch.countDown();
        }
    }
}
