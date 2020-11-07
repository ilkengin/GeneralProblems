package com.ilkengin.mindiff;

public class Application {
	public static void main(String[] args) {
		int[] nums = new int[] {6, 6, 0, 1, 1, 4, 6 };
		MinimumDifferenceFinder diffFinder = new MinimumDifferenceFinder();
		System.out.println(diffFinder.minDifference(nums));
	}
}
