package com.pensejava.newobject.core;

import java.util.Random;

/**
 * Reordena as palavras
 */
public final class Parce {

    private static Random random = new Random();

    public static String nextString(String value){
        value = (value == null)? "abcdefghigklmnopqrstuvwxyz1234567890" : value;
        char[] chars = value.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public static int nextInt(int value){
        value = (value == 0)? 1 : value;
        return random.nextInt(value);
    }

    public static long nextLong(long value){
        return new Random().nextLong();
    }

    public static byte[] nextByte(byte[] value){
        random.nextBytes(value);
        return value;
    }

    public static double nextDouble(){
        return random.nextDouble();
    }

    public static float nextFloat(){
        return random.nextFloat();
    }

    public static boolean nextBoolean(boolean value){
        return random.nextBoolean();
    }
}
