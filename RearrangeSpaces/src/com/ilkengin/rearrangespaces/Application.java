package com.ilkengin.rearrangespaces;

public class Application {

	public static void main(String[] args) {
		String text = " practice   makes   perfect";
		SpaceArranger spaceArranger = new SpaceArranger();
		System.out.println(spaceArranger.reorderSpaces(text));
	}

}
