package com.ilkengin.trie;

class Trie {
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();    
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        
        for(char c: word.toCharArray()) {
            if(!node.edges.containsKey(c)) {
                node.edges.put(c, new TrieNode());
            }
            
            node = node.edges.get(c);
        }
        
        node.isNodeEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            if(!node.edges.containsKey(c)) {
                return false;
            }
            node = node.edges.get(c);
        }
        
        return node.isNodeEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c: prefix.toCharArray()) {
            if(!node.edges.containsKey(c)) {
                return false;
            }
            node = node.edges.get(c);
        }
        
        return true;
    }
}
