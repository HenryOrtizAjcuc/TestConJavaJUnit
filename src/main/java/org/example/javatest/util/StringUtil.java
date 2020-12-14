package org.example.javatest.util;

public class StringUtil {

    public static String repeat(String str, int times) {
        if (times < 0) {
            throw new IllegalArgumentException("negative times not allowed");
        }

        StringBuilder result = new StringBuilder();


        for (int i = 0; i < times; i++) {
            result.append(str);
        }
        return result.toString();
    }

    public static boolean isEmpty(String str) {
        if (str == null) {
            throw new NullPointerException("El valor no puede ser nulo.");
        } else return str.trim().replace(" ", "").equals("");
    }
}
