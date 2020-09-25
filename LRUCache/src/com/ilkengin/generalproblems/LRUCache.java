package com.ilkengin.generalproblems;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;
    private Map<Integer, CacheNode> map;
    
    private CacheNode head;
    private CacheNode tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = tail = null;
    }
    
    public int get(int key) {
        //System.out.println(String.format("Getting %d", key));

        if (map.containsKey(key)) {
            CacheNode node = map.get(key);
            
            // We should put the node to the head
            if(head != node) {
                //System.out.println("The node is not head: " + key + ":" + node.value);
                if (tail == node && map.size() > 1) {
                    //System.out.println("The node is tail: " + key + ":" + node.value);
                    tail = tail.prev;
                    tail.next = null;
                    //System.out.println("Tail is set to: " + tail.key + ":" + tail.value);
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                
                //System.out.println("Head is : " + head.key + ":" + head.value);

                head.prev = node;
                node.next = head;
                head = node;
            } else {
                //System.out.println("The node is head: " + key);
            }
            
            return node.value;
        }
        
        //System.out.println("Item is not found: " + key);
        return -1;
    }
    
    public void put(int key, int value) {
        //System.out.println(String.format("Putting %d:%d", key, value));
        
        // Item is in the list
        if(map.containsKey(key)) {
            //System.out.println("Item is in the list: " + key + ":" + value);
            CacheNode node = map.get(key);
            
            if(node == head) {
                head = head.next;
            } else if(node == tail) {
                node.prev.next = null;
                tail = node.prev;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }
        
        // Item is not in the cache and capacity is full
        // We need to remove tail from cache
        if (map.size() == capacity && !map.containsKey(key)) {
            //System.out.println("Item is not in the list and capacity is full: " + key + ":" + value);
            //System.out.println("Removing tail: " + tail.key + ":" + tail.value);
            map.remove(tail.key);

            if(head == tail) {
                // capacity is one
                tail = head = null;
            } else {
                tail = tail.prev;
                tail.next = null; 
            }
        }
        
        CacheNode node = new CacheNode(key, value);
        //System.out.println("Created item: " + key + ":" + value);
        
        node.next = head;
        
        if (head != null) {
            head.prev = node;
        } else {
            tail = node;
        }
        
        head = node;
        
        map.put(key, node);
        //System.out.println("New tail: " + (tail != null ? tail.key : null) + ":" + (tail != null ? tail.value : null));
    }
}