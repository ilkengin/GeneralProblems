package com.ilkengin.reverseinteger;

public class IntegerReverser {
	
    public int reverse(int x) {
        long reverseOfNum = 0;
        
        while (x != 0) {
            int digit = x % 10;
            reverseOfNum = reverseOfNum * 10 + digit;
            x = x / 10;
        }
                
        if (reverseOfNum < Integer.MIN_VALUE || reverseOfNum > Integer.MAX_VALUE) {
            return 0;
        }
        
        return (int) reverseOfNum;
    }
	
}
