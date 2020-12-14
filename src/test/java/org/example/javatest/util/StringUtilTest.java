package org.example.javatest.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    // convención nombres tests:
    // methodNameUnderTest_givenCondition_expectedBehavio
    @Test
    public  void repeat_string_once(){
        Assert.assertEquals("hola",StringUtil.repeat("hola",1));
    }

    @Test
    public  void repeat_string_multple_times(){
        Assert.assertEquals("holaholahola",StringUtil.repeat("hola",3));
    }

    @Test
    public  void repeat_string_zero_times(){
        Assert.assertEquals("",StringUtil.repeat("hola",0));
    }

    @Test(expected = IllegalArgumentException.class)
    public  void repeat_string_negative_times(){
        StringUtil.repeat("hola",-4);
    }

    @Test
    public void string_is_not_empty(){
        Assert.assertFalse(StringUtil.isEmpty("jsldjflajdlfña"));
    }

    @Test
    public void string_is_empty(){
        Assert.assertTrue(StringUtil.isEmpty(""));
    }

    @Test (expected = NullPointerException.class)
    public void null_is_empty(){
        StringUtil.isEmpty(null);
    }

    @Test
    public void string_with_only_spaces_is_empty(){
        Assert.assertTrue(StringUtil.isEmpty("     "));
    }
}