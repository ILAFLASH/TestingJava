package com.testingjava.test11;

interface MyFunc<T> {
    boolean func(T v1, T v2);
}

class HighTemp {
    private int hTemp;

    public HighTemp(int hTemp) {
        this.hTemp = hTemp;
    }

    boolean sameTemp( HighTemp ht) {
        return hTemp == ht.hTemp;
    }

    boolean higherTemp(HighTemp ht) {
        return hTemp > ht.hTemp;
    }
}

public class TestingStaticRefAdvanced {

    static<T> int counter(T[] vals, MyFunc<T> f, T v) {
        int count = 0;

        for (int i = 0; i < vals.length; i++) {
            if (f.func(v, vals[i])) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int count = 0;

        HighTemp[] weekDaysHighs = {new HighTemp(89), new HighTemp(82), new HighTemp(90),
        new HighTemp(89), new HighTemp(89), new HighTemp(91), new HighTemp(84), new HighTemp(83)};

        // У интерфейса 2 параметра, а у функции sameTemp - 1
        // Поэтому в качестстве первого параметра берется объект на котором вызывается метод sameTemp
        count = counter(weekDaysHighs, HighTemp::sameTemp, new HighTemp(90));

        System.out.println(count);

        count = counter(weekDaysHighs, HighTemp::higherTemp, new HighTemp(85));

        System.out.println(count);
    }
}
