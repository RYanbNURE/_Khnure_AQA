package com.company.modulejava.lecture8;

public class Ex18RegexTestStrings {


//        s.matches("regex")
//
//    Evaluates if "regex" matches s. Returns only true if the WHOLE string can be matched.
//
//        s.split("regex")
//
//    Creates an array with substrings of s divided at occurrence of "regex". "regex" is not included in the result.
//
//        s.replaceFirst("regex"), "replacement"
//
//    Replaces first occurance of "regex" with "replacement.
//
//            s.replaceAll("regex"), "replacement"
//
//    Replaces all occurances of "regex" with "replacement.

    public static final String EXAMPLE_TEST = "This is my small example "
            + "string which I'm going to " + "use for pattern matching.";

    public static void main(String[] args) {
        System.out.println(EXAMPLE_TEST.matches("\\w.*"));
        String[] splitString = (EXAMPLE_TEST.split("\\s+"));
        System.out.println(splitString.length);// should be 14
        for (String string : splitString) {
            System.out.println(string);
        }
        // replace all whitespace with tabs
        System.out.println(EXAMPLE_TEST.replaceAll("\\s+", "\t"));
    }
}