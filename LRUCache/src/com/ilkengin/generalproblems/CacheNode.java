package com.ilkengin.generalproblems;

public class CacheNode {
    Integer key;
    Integer value;
    CacheNode prev;
    CacheNode next;
    
    CacheNode(Integer k, Integer val) {
        key = k;
        value = val;
        prev = null;
        next = null;
    }
}