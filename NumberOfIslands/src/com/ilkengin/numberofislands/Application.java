package com.ilkengin.numberofislands;

public class Application {

	public static void main(String[] args) {
		IslandCountCalculator islandCountCalculator = new IslandCountCalculator();
		System.out.println(islandCountCalculator.numIslands(new char[][] {
			{'1','1','1','1','0'},
			{'1','1','0','1','0'},
			{'1','1','0','0','0'},
			{'0','0','0','0','0'}
		}));
		
		System.out.println(islandCountCalculator.numIslands(new char[][] {
			  {'1','1','0','0','0'},
			  {'1','1','0','0','0'},
			  {'0','0','1','0','0'},
			  {'0','0','0','1','1'}
		}));
		
	}

}
