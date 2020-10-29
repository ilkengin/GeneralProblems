package com.ilkengin.freshpromotion;

import java.util.Arrays;
import java.util.List;

public class Application {

	public static void main(String[] args) {
        List<List<String>> secretCodes = Arrays.asList(
                Arrays.asList("apple", "apple"),
                Arrays.asList("banana", "anything", "banana")
            );
            List<String> shoppingCart = Arrays.asList("orange", "apple", "apple", "banana", "orange", "banana");
            FreshPromotionValidator validator = new FreshPromotionValidator();
            
            System.out.println(validator.isValidForPromotion(secretCodes, shoppingCart));
	}
}
