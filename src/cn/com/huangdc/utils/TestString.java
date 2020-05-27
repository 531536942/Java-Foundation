package cn.com.huangdc.utils;

import org.junit.Test;

public class TestString {

    @Test
    public void test1 () {
        String str1 = "java";
        String str2 = new String("java");
        String str3 = "android";
        String str4 = "java" + "android";
        String str5 = str1 + str3 ;
        String str6 = str5.intern();

        System.out.println(str1 == str2);// false
        System.out.println(str1.equals(str2));// true
        System.out.println(str4 == str5);// false
        System.out.println(str4.equals(str5));// true
        System.out.println(str4 == str6);// true
    }

    public void test2() {
        String str1 = "qwer";
        str1.length();
        str1.charAt(1);
        str1.equals(new String("qwer"));
        str1.compareTo(new String("qwer"));
        str1.indexOf("w");
        str1.indexOf("e",2 );
        str1.lastIndexOf("q");
        str1.startsWith("qw");
    }
}
