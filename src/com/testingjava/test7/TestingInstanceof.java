package com.testingjava.test7;

class Gen<T> {
    private T ob;

    public Gen(T ob) {
        this.ob = ob;
    }

    public T getOb() {
        return ob;
    }
}

class Gen2<T> extends Gen<T> {

    public Gen2(T ob) {
        super(ob);
    }
}

public class TestingInstanceof {
    public static void main(String[] args) {
        Gen<Integer> iOb = new Gen<>(88);

        Gen2<Integer> iOb2 = new Gen2<>(99);

        Gen2<String> strOb = new Gen2<>("New string");

        if (iOb instanceof Gen) System.out.println(iOb.getOb() + " является экземпляром " + Gen.class.getName());

        if (iOb instanceof Gen2) System.out.println(iOb.getOb() + " является экземпляром " + Gen2.class.getName());

        if (iOb2 instanceof Gen) System.out.println(iOb2.getOb() + " является экземпляром " + Gen.class.getName());

        if (iOb2 instanceof Gen2) System.out.println(iOb2.getOb() + " является экземпляром " + Gen2.class.getName());

        if (strOb instanceof Gen) System.out.println(strOb.getOb() + " является экземпляром " + Gen.class.getName());

        if (strOb instanceof Gen2) System.out.println(strOb.getOb() + " является экземпляром " + Gen2.class.getName());
     }
}
