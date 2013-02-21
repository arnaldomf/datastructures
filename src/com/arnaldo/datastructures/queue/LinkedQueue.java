package com.arnaldo.datastructures.queue;

import java.util.Iterator;

public class LinkedQueue<Item> implements Iterable<Item>{
	private class Node {
		Item item;
		Node next;
	}
	private Node head;
	private Node tail;
	private int N;
	
	public boolean isEmpty(){
		return head == null;
	}
	public int size() {
		return N;
	}
	
	public void enqueue(Item item) {
		Node oldTail = tail;
		tail = new Node();
		tail.item = item;
		if(isEmpty()){
			head = tail;
		}
		else {
			oldTail.next = tail;
		}
		N++;
	}
	
	public Item dequeue(){
		if(isEmpty()){
			return null;
		}
		Item item = head.item;
		head = head.next;
		N--;
		if (size() == 0) {
			tail = head;
		}
		return item;
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new LinkedQueueIterator();
	}
	
	private class LinkedQueueIterator implements Iterator<Item> {

		private Node current = head;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}	
}
