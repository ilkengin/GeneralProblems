package com.ilkengin.deepcopylinkedlist;

import java.util.HashMap;
import java.util.Map;

public class LinkedListDeepCopier {
	public Node copyRandomList(Node head) {   
        // Mapping between nodes in old list and new list
        Map<Node, Node> nodeMap = new HashMap<>();
        
        // traverse the list being copied
        Node node = head;
        while(node != null) {         
            // If the node was not being created before, create it 
            if (nodeMap.getOrDefault(node, null) == null) {
                nodeMap.put(node, new Node(node.val));
            }
            
            Node newNode = nodeMap.get(node);           
            
            // Next is not created yet
            if(node.next != null && nodeMap.getOrDefault(node.next, null) == null) {
                nodeMap.put(node.next, new Node(node.next.val));
            }
            newNode.next = nodeMap.getOrDefault(node.next, null);
            
            // Random is not created yet
            if(node.random != null && nodeMap.getOrDefault(node.random, null) == null) {
                nodeMap.put(node.random, new Node(node.random.val));
            }
            newNode.random = nodeMap.getOrDefault(node.random, null);
            node = node.next;
        }

        return nodeMap.getOrDefault(head, null);
    }
}
