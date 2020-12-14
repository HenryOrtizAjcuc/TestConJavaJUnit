package org.example.javatest.practices;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class RomanNumeralsShould {

    @Test
    public void retun_number_arabic_to_roman() {
        assertThat(RomanNumerals.arabicToRoman(1), is("I"));
        assertThat(RomanNumerals.arabicToRoman(2), is("II"));
        assertThat(RomanNumerals.arabicToRoman(3), is("III"));
        assertThat(RomanNumerals.arabicToRoman(5), is("V"));
        assertThat(RomanNumerals.arabicToRoman(6), is("VI"));
        assertThat(RomanNumerals.arabicToRoman(7), is("VII"));
        assertThat(RomanNumerals.arabicToRoman(10), is("X"));
        assertThat(RomanNumerals.arabicToRoman(11), is("XI"));
        assertThat(RomanNumerals.arabicToRoman(15), is("XV"));
        assertThat(RomanNumerals.arabicToRoman(16), is("XVI"));
        assertThat(RomanNumerals.arabicToRoman(50), is("L"));
        assertThat(RomanNumerals.arabicToRoman(51), is("LI"));
        assertThat(RomanNumerals.arabicToRoman(55), is("LV"));
        assertThat(RomanNumerals.arabicToRoman(56), is("LVI"));
        assertThat(RomanNumerals.arabicToRoman(60), is("LX"));
        assertThat(RomanNumerals.arabicToRoman(70), is("LXX"));
        assertThat(RomanNumerals.arabicToRoman(80), is("LXXX"));
        assertThat(RomanNumerals.arabicToRoman(81), is("LXXXI"));
        assertThat(RomanNumerals.arabicToRoman(85), is("LXXXV"));
        assertThat(RomanNumerals.arabicToRoman(86), is("LXXXVI"));
        assertThat(RomanNumerals.arabicToRoman(126), is("CXXVI"));
        assertThat(RomanNumerals.arabicToRoman(2507), is("MMDVII"));

        // En los siguientes tests, probamos los casos en los que hay símbolos que restan, porque van a la izquierda de un símbolo mayor.
        assertThat(RomanNumerals.arabicToRoman(4), is("IV"));
        assertThat(RomanNumerals.arabicToRoman(9), is("IX"));
        assertThat(RomanNumerals.arabicToRoman(19), is("XIX"));
        assertThat(RomanNumerals.arabicToRoman(24), is("XXIV"));
        assertThat(RomanNumerals.arabicToRoman(40), is("XL"));
        assertThat(RomanNumerals.arabicToRoman(49), is("XLIX"));
        assertThat(RomanNumerals.arabicToRoman(90), is("XC"));
        assertThat(RomanNumerals.arabicToRoman(99), is("XCIX"));
        assertThat(RomanNumerals.arabicToRoman(400), is("CD"));
        assertThat(RomanNumerals.arabicToRoman(900), is("CM"));
    }

}