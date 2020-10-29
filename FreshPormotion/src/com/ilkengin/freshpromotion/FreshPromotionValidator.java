package com.ilkengin.freshpromotion;

import java.util.List;

public class FreshPromotionValidator {
    public int isValidForPromotion(List<List<String>> secretCodes, List<String> shoppingCart) {
        int currentSearchIndex = 0;
        for(List<String> secretCode: secretCodes) {
            int foundIndex = findIndexOfCodeListInShoppingCart(secretCode, shoppingCart, currentSearchIndex);
            
            if (foundIndex == -1) {
                return 0;
            }
            
            currentSearchIndex = foundIndex + secretCode.size();
        }
        
        return 1;
    }
    
    private int findIndexOfCodeListInShoppingCart(List<String> secretCode, List<String> shoppingCart, int startIndex) {
        int i = startIndex;
        int j = 0; // search index in seret code
        while (i < shoppingCart.size() && j < secretCode.size()) {
            if(secretCode.get(j).equals("anything") || secretCode.get(j).equals(shoppingCart.get(i))) {
                i++;
                j++;
            } else {
                i++;
                j = 0;
            }
        }
        
        if (j == secretCode.size()) {
            return i - secretCode.size();
        }
        
        return -1;
    }
}
