package com.ilkengin.deepcopylinkedlist;

public class Application {

	public static void main(String[] args) {
		Node head = generateLinkedList();
		LinkedListDeepCopier copier = new LinkedListDeepCopier();
		copier.copyRandomList(head);
	}

	private static Node generateLinkedList() {
		return null;
	}
	
}
