package com.ash.linkedlist;

public class InsertIntoPositionLinkedList {

	public static void main(String[] args) {
		Node head = new Node();
		head.data = 2;
		Node newHead = InsertNth(head, 3, 2);
		System.out.println(newHead);
	}

	static Node InsertNth(Node head, int data, int position) {
		Node newNode = new Node();
		newNode.data = data;
		if (head == null) {
			return newNode;
		} else if (position == 0) {
			newNode.next = head;
			return newNode;
		} else {
			int counter = 1;
			Node currentPointer = head;
			while (currentPointer.next != null) {
				if (counter == position) {
					break;
				}
				counter++;
				currentPointer = currentPointer.next;
			}
			newNode.next = currentPointer.next;
			currentPointer.next = newNode;
			return head;
		}
	}
}
