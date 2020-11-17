package com.ilkengin.longestword;

public class Application {

	public static void main(String[] args) {
		LongestWordFinder lwf = new LongestWordFinder();
		String[] words = new String[] { "a", "banana", "app", "appl", "ap", "apply", "apple" };
		System.out.println(lwf.longestWord(words));
	}
}
