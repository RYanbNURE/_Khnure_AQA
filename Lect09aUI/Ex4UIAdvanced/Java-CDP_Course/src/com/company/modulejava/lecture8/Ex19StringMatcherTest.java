package com.company.modulejava.lecture8;

public class Ex19StringMatcherTest {
    public static void main(String[] args) {
        Ex19StringMatcher m = new Ex19StringMatcher();


        System.out.println(m.isTrue("true"));
        System.out.println(m.isTrue("true2"));
        System.out.println(m.isTrue("True"));

        System.out.println(m.isTrueVersion2("true"));
        System.out.println(m.isTrueVersion2("true2"));
        System.out.println(m.isTrueVersion2("True"));;

        System.out.println(m.isTrueOrYes("true"));
        System.out.println(m.isTrueOrYes("yes"));
        System.out.println(m.isTrueOrYes("Yes"));
        System.out.println(m.isTrueOrYes("no"));

        System.out.println(m.containsTrue("thetruewithin"));

        System.out.println(m.isThreeLetters("abc"));
        System.out.println(m.isThreeLetters("abcd"));

        System.out.println(m.isNoNumberAtBeginning("abc"));
        System.out.println(m.isNoNumberAtBeginning("1abcd"));
        System.out.println(m.isNoNumberAtBeginning("a1bcd"));
        System.out.println(m.isNoNumberAtBeginning("asdfdsf"));

        System.out.println(m.isIntersection("1"));
        System.out.println(m.isIntersection("abcksdfkdskfsdfdsf"));
        System.out.println(m.isIntersection("skdskfjsmcnxmvjwque484242"));

        System.out.println(m.isLessThenThreeHundred("288"));
        System.out.println(m.isLessThenThreeHundred("3288"));
        System.out.println(m.isLessThenThreeHundred("328 8"));
        System.out.println(m.isLessThenThreeHundred("1"));
        System.out.println(m.isLessThenThreeHundred("99"));
        System.out.println(m.isLessThenThreeHundred("300"));
    }
}
