package com.ilkengin.rearrangespaces;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.lang.StringBuilder;

public class SpaceArranger {
    public String reorderSpaces(String text) {
        int spaceCount = (int) text.chars().filter(Character::isWhitespace).count();
        List<String> nonEmptyWords = Arrays.stream(text.trim().split("\\s+"))
            .filter(item -> !item.trim().isEmpty())
            .collect(Collectors.toList());

        int spaceCountForWord = 0;
            
        if (nonEmptyWords.size() > 1) {
            spaceCountForWord = spaceCount / (nonEmptyWords.size() - 1);
        }
        
        StringBuilder builder = new StringBuilder();
        
        for(int i = 0; i < nonEmptyWords.size(); i++) {
            String word = nonEmptyWords.get(i);
            builder.append(word);
            
            if (i != nonEmptyWords.size() - 1) { //Do not add space for last word
                for(int j = 0; j < spaceCountForWord; j++) {
                    builder.append(" ");    
                }                
            }

        }
        if (spaceCount > 0 && nonEmptyWords.size() > 0) {
            int leadingSpaceCount = nonEmptyWords.size() == 1 ? 
                spaceCount : 
                spaceCount % (nonEmptyWords.size() - 1);
            for(int i = 0; i < leadingSpaceCount; i++) {
                builder.append(" ");
            }            
        }
        
        return builder.toString();
    }
}
