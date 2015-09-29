package com.ash.linkedlist;

public class ReverseLinkedList {

	public static void main(String[] args) {
		Node n1 = new Node(3, null);
		Node n2 = new Node(2, n1);

		ReverseLinkedList.Reverse(n2);
	}

	static Node Reverse(Node head) {
		// null list
		if (head == null) {
			return head;
		}

		// one element list
		if (head.next == null) {
			return head;
		}

		Node currentNode = head;
		Node secondNode = head.next;

		// head now points to null
		currentNode.next = null;

		while (secondNode != null) {
			Node tmp = secondNode.next;
			secondNode.next = currentNode;

			currentNode = secondNode;
			secondNode = tmp;
		}

		return currentNode;
	}

}
