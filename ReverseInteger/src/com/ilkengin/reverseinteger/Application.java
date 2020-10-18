package com.ilkengin.reverseinteger;

public class Application {

	public static void main(String[] args) {
		IntegerReverser reverser = new IntegerReverser();
		int reverse = reverser.reverse(123);
		System.out.println(reverse);
		
		reverse = reverser.reverse(-123);
		System.out.println(reverse);
		
		reverse = reverser.reverse(Integer.MAX_VALUE);
		System.out.println(reverse);
		
		reverse = reverser.reverse(0);
		System.out.println(reverse);
	}

}
