package com.testingjava.test26;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestingAddress {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);

        address = InetAddress.getByName("www.HerbSchildt.com");
        System.out.println(address);

        InetAddress[] addresses = InetAddress.getAllByName("www.nba.com");

        for (InetAddress inetAddress: addresses) {
            System.out.println(inetAddress);
        }
    }
}
