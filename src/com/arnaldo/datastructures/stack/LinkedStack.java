package com.arnaldo.datastuctrures.stack;

import java.util.Iterator;


public class LinkedStack<Item> implements Iterable<Item> {
	
	private Node first;
	private int N = 0;
	
	public boolean isEmpty() { return first == null;}
	public int size() { return N; }
	
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.next = oldfirst;
		first.item = item;
		N++;
	}
	
	public Item pop(){
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	
	
	private class Node {
		Item item;
		Node next;
	}
	
	
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new LinkedStackIter();
	}
	
	private class LinkedStackIter implements Iterator<Item> {

		private Node current = first;
		@Override
		public boolean hasNext() {
			return  current != null;
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
