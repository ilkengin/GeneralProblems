package com.ilkengin.kmp;

public class Application {

	public static void main(String[] args) {
		PatternMatcher patternMatcher = new PatternMatcher();
		String haystack = "hello";
		String needle = "ll";
		System.out.println(patternMatcher.strStr(haystack, needle));
	}
}
