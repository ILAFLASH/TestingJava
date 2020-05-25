package com.testingjava.test25;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;

public class TestingChannel {

    public static void main(String[] args) {
        int count;

        Locale.setDefault(new Locale("ru")); // не работает, как я думал

        // Здесь канал открывается по пути, возвращаемому методом Paths.get() в виде объекта типа Path
        try (SeekableByteChannel byteChannel = Files.newByteChannel(Paths.get("src/com/testingjava/test25/test.txt"))) {
            // Выделить память под буфер
            ByteBuffer byteBuffer = ByteBuffer.allocate(128);

            do {
                // читать данные из файла в буфер
                count = byteChannel.read(byteBuffer);

                // прекратить чтение по достижении конца файла
                if (count != -1) {

                    // подготовить буфер к чтению из него данных
                    byteBuffer.rewind();

                    // читать байты данных из буфера и выводить их не экран как символы
                    for (int i = 0; i < count ; i++) {
                        System.out.print((char) byteBuffer.get());
                    }
                }

            } while (count != -1);

        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);;
        }

    }
}
