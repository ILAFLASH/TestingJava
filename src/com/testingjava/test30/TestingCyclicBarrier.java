package com.testingjava.test30;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestingCyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarAction());

        System.out.println("Запуск потоков");

        Thread a = new Thread(new MyThread(cb, "A"));
        Thread b = new Thread(new MyThread(cb, "B"));
        Thread c = new Thread(new MyThread(cb, "C"));
        Thread x = new Thread(new MyThread(cb, "X"));
        Thread y = new Thread(new MyThread(cb, "Y"));
        Thread z = new Thread(new MyThread(cb, "Z"));
        a.start();
        b.start();
        c.start();
        x.start();
        y.start();
        z.start();
    }
}

class MyThread implements Runnable {
    CyclicBarrier cbar;
    String name;

    public MyThread(CyclicBarrier cbar, String name) {
        this.cbar = cbar;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);

        try {
            cbar.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class BarAction implements Runnable {
    @Override
    public void run() {
        System.out.println("Барьер достигнут!");
    }
}
