package com.ilkengin.kmp;

public class PatternMatcher {
    public int strStr(String haystack, String needle) {
        int[] kmpTable = buildKMPTable(needle);
        int i = 0, j = 0;
        while(i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else if (j > 0) {
                j = kmpTable[j - 1];
            } else {
                i++;
            }
        }
        if (j == needle.length()) {
            return i - needle.length();
        }
        return -1;
    }
    
    private int[] buildKMPTable(String pattern) {
        int n = pattern.length();
        int[] table = new int[n];
        for(int i = 1, j = 0; i < n; i++) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                table[i] = ++j;
            } else if (j > 0) {
                j =  table[j - 1];
                i--;
            }
        }
        return table;
    }
}
