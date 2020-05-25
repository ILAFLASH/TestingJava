package com.testingjava.test5;

public class GenericsTestingAdvanced {
}

class TwoD {
    int x, y;

    public TwoD(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class ThreeD extends TwoD {
    int z;

    public ThreeD(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
}

class FourD extends ThreeD {
    int t;

    public FourD(int x, int y, int z, int t) {
        super(x, y, z);
        this.t = t;
    }
}

class Coordinates<T extends TwoD> {
    T[] coordinates;

    public Coordinates(T[] coordinates) {
        this.coordinates = coordinates;
    }

    public static void showXY(Coordinates<?> c) {
        for (int i = 0; i < c.coordinates.length; i++) {
            System.out.println("X = " + c.coordinates[i].x);
            System.out.println("Y = " + c.coordinates[i].y);
        }
    }

    public static void showXYZ(Coordinates<? extends ThreeD> c) {
        for (int i = 0; i < c.coordinates.length; i++) {
            System.out.println("X = " + c.coordinates[i].x);
            System.out.println("Y = " + c.coordinates[i].y);
            System.out.println("Z = " + c.coordinates[i].z);
        }
    }

    public static void showXYZT(Coordinates<? extends FourD> c) {
        for (int i = 0; i < c.coordinates.length; i++) {
            System.out.println("X = " + c.coordinates[i].x);
            System.out.println("Y = " + c.coordinates[i].y);
            System.out.println("Z = " + c.coordinates[i].z);
            System.out.println("T = " + c.coordinates[i].t);
        }
    }

    public static void main(String[] args) {
        TwoD twoD[] = {new TwoD(0, 0),
                new TwoD(7, 9),
                new TwoD(18, 14),
                new TwoD(-1, -23)};

        Coordinates<TwoD> coords1 = new Coordinates<>(twoD);

        coords1.showXY(coords1);

        ThreeD threeD[] = {new ThreeD(1, 2, 3),
                new ThreeD(4, 6, 7),
                new ThreeD(34, 45, 8),
                new ThreeD(-3, -6, -75)};

        Coordinates<ThreeD> coords2 = new Coordinates<>(threeD);

        showXY(coords2);
        System.out.println();
        showXYZ(coords2);

        FourD fourD[] = {new FourD(1, 2, 34, 3),
                new FourD(4, 6, 7, 43),
                new FourD(34, 45, 8, 95),
                new FourD(-3, -6, -75, 0)};

        Coordinates<FourD> coords3 = new Coordinates<>(fourD);

        showXYZT(coords3);
    }
}
