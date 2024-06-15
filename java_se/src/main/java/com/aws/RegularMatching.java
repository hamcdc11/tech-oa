package com.aws;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularMatching {
    public static void main(String[] args) {
        String reg1 = "(a.b)*bd";
        String[] strs1 = {"acbabbbd", "bd", "abbd"};
        System.out.println(Arrays.toString(isRegexMatching(reg1, strs1)));//y y n

        String reg2 = "ab(e.r)*e";
        String[] strs2 = {"abbeere", "abefretre"};
        System.out.println(Arrays.toString(isRegexMatching(reg2, strs2))); //n y

        String reg3 = "..()*e*";
        String[] strs3 = {"code", "abeee", "cd"};
        System.out.println(Arrays.toString(isRegexMatching(reg3, strs3))); // n y y
    }

    public static String[] isRegexMatching(String regex, String[] arr) {
        String[] results = new String[arr.length];
        Pattern pattern = convertToPattern(regex);

        for (int i = 0; i < arr.length; i++) {
            Matcher matcher = pattern.matcher(arr[i]);
            if (matcher.matches()) {
                results[i] = "YES";
            } else {
                results[i] = "NO";
            }
        }
        return results;
    }

    private static Pattern convertToPattern(String regex) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < regex.length(); i++) {
            char c = regex.charAt(i);
            if (c == '.') {
                sb.append("[a-z]");
            } else if (c == '(') {
                sb.append("(");
            } else if (c == ')') {
                sb.append(")");
            } else if (c == '*') {
                sb.append("*");
            } else {
                sb.append(Pattern.quote(String.valueOf(c)));
            }
        }
        return Pattern.compile(sb.toString());
    }
}
