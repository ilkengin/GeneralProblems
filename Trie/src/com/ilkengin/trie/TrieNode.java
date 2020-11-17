package com.ilkengin.trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> edges;
    boolean isNodeEnd;
    
    public TrieNode() {
        edges = new HashMap<>();
        isNodeEnd = false;
    }
}
