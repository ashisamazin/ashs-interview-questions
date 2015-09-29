package com.ash.linkedlist;

public class DeleteFromLinkedList {

	public static void main(String[] args) {
		Node head = new Node();
		head.data = 2;
		Node newHead = Delete(head, 3);
		System.out.println(newHead);
	}

	static Node Delete(Node head, int position) {
		if (position == 0) {
			return head.next;
		}

		Node currentPointer = head;
		for (int i = 1; i < position; i++) {
			currentPointer = currentPointer.next;
		}
		currentPointer.next = currentPointer.next.next;
		return head;
	}
}
