package com.ilkengin.longestword;

public class LongestWordFinder {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        
        for(String word: words) {
            trie.insert(word);
        }
        
        return trie.getLongestWord();
    }
}
