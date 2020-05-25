package com.testingjava.test36;

import java.util.concurrent.RecursiveTask;

// Класс RecursiveTask, используемый для вычисления суммы значений элементов в массиве типа Double
class Sum extends RecursiveTask<Double> {
    // Пороговое значение
    final int seqThreshold = 500;

    double[] data;

    int start, end;

    public Sum(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Double compute() {
        double sum = 0;
        if (end - start < seqThreshold) {
            for (int i = start; i < end; i++) {
                sum += data[i];
            }
        } else {

            int middle = (end + start) / 2;
            Sum subTaskA = new Sum(data, start, middle);
            Sum subTaskB = new Sum(data, middle, end);

            subTaskA.fork();
            subTaskB.fork();

            sum = subTaskA.join() + subTaskB.join();
        }
        return sum;
    }
}

public class TestingRecursiveTask {
    public static void main(String[] args) {
//        ForkJoinPool fjp = ForkJoinPool.commonPool();

        double[] nums = new double[5000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = ((i % 2) == 0 ? i : -i);
        }

        Sum task = new Sum(nums, 0, nums.length);

//        double summation = fjp.invoke(task);
        double summation = task.invoke();
        System.out.println("Суммирование " + summation);
    }
}
