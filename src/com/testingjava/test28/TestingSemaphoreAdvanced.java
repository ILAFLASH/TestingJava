package com.testingjava.test28;

import java.util.concurrent.Semaphore;

// Реализация поставщика и потребителя, использующая семафоры для управления синхронизацией

class Q {
    int n;

    // начать с недоступного семафора потребителя
    static Semaphore semCon = new Semaphore(0);
    static Semaphore semProd = new Semaphore(1);

    void get() {
        try {
            semCon.acquire();
        } catch (InterruptedException e) {
            System.out.println("Перехвачено исключение типа " + e);
        }

        System.out.println("Получено: " + n);
        semProd.release();
    }

    void put(int n) {
        try {
            semProd.acquire();
        } catch (InterruptedException e) {
            System.out.println("Перехвачено исключение типа " + e);
        }

        this.n = n;
        System.out.println("Отправлено: " + n);
        semCon.release();
    }
}

class Producer implements Runnable {
    Q q;

    public Producer(Q q) {
        this.q = q;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20 ; i++) {
            q.put(i);
        }
    }
}

class Consumer implements Runnable {
    Q q;

    public Consumer(Q q) {
        this.q = q;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20 ; i++) {
            q.get();
        }
    }
}

public class TestingSemaphoreAdvanced {
    public static void main(String[] args) {
        Q q = new Q();
        new Thread(new Consumer(q), "Consumer").start();
        new Thread(new Producer(q), "Producer").start();
    }
}
