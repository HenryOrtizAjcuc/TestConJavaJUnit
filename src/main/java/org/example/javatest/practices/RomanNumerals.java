package org.example.javatest.practices;

public class RomanNumerals {
    public static String arabicToRoman(int n) {
        StringBuilder numberRoman = new StringBuilder();

        while (n > 0) {
            if (n >= 1000) {
                numberRoman.append("M");
                n -= 1000;
                continue;
            }
            if (n >= 900) {
                numberRoman.append("CM");
                n -= 900;
                continue;
            }
            if (n >= 500) {
                numberRoman.append("D");
                n -= 500;
                continue;
            }
            if (n >= 400) {
                numberRoman.append("CD");
                n -= 400;
                continue;
            }
            if (n >= 100) {
                numberRoman.append("C");
                n -= 100;
                continue;
            }
            if (n >= 90) {
                numberRoman.append("XC");
                n -= 90;
                continue;
            }
            if (n >= 50) {
                numberRoman.append("L");
                n -= 50;
                continue;
            }
            if (n >= 40) {
                numberRoman.append("XL");
                n -= 40;
                continue;
            }
            if (n >= 10) {
                numberRoman.append("X");
                n -= 10;
                continue;
            }
            if (n == 9) {
                numberRoman.append("IX");
                n -= 9;
                continue;
            }
            if (n >= 5) {
                numberRoman.append("V");
                n -= 5;
                continue;
            }
            if (n == 4) {
                numberRoman.append("IV");
                n -= 4;
                continue;
            }
            numberRoman.append("I");
            n -= 1;
        }
        return numberRoman.toString();
    }
}
