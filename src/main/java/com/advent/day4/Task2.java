package com.advent.day4;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(searchNumber("bgvyzdsv"));
    }

    private static int searchNumber(String input) {
        MD5 md5 = new MD5();
        String hash = md5.getMD5Hash(input.getBytes());
        String buf;
        int i;

        for (i = 0; !hash.startsWith("000000"); i++){
            buf = input + i;
            hash = md5.getMD5Hash(buf.getBytes());
        }
        return i - 1;
    }
}
