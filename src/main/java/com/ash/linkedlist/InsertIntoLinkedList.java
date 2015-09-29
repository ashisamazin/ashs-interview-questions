package com.ash.linkedlist;

public class InsertIntoLinkedList {

	public static void main(String[] args) {
		Node head = new Node();
		head.data = 2;
		Node newHead = Insert(head, 3);
		System.out.println(newHead);
	}

	static Node Insert(Node head, int data) {
		Node newNode = new Node();
		newNode.data = data;
		if (head == null) {
			return newNode;
		} else {
			Node currentPointer = head;
			while (currentPointer.next != null) {
				currentPointer = currentPointer.next;
			}
			currentPointer.next = newNode;
			return head;
		}
	}
}
