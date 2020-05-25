package com.testingjava.test1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ByteArray {

    public byte[] addArray() {
        byte[] array=null;

        try {
            array = Files.readAllBytes(Paths.get("src/com/testingjava/test1/cat.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return array;
    }

    public static void main(String[] args) {
        ByteArray byteArray = new ByteArray();
        System.out.println(Arrays.toString(byteArray.addArray()));
    }
}
