package com.testingjava.test3;

public enum AppleEnum {
    Jonathan(10), ColdenDel(), RedDel(12), Winesap(15), Cortland(8);

    private int price;

    AppleEnum(int price) {
        this.price = price;
    }

    AppleEnum() { this.price = 0;}

    public int getPrice() {
        return price;
    }
}
