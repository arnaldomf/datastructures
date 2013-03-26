package com.datastructures.symboltable;

import com.datastructures.queue.Queue;


// Unordered SymbolTable

public class SequentialSearchST<Key, Value> {
	
	private class Node {
		public Node next;
		public Value value;
		public Key key;
		
		public Node(Key k, Value v, Node next) {
			this.key = k;
			this.value = v;
			this.next = next;
		}
	}
	private Node first;
	private int size = 0;
	
	public SequentialSearchST(){
	}
	
	public void put(Key k, Value v) {
		for (Node x = first; x != null; x = x.next) 
			if(k.equals(x.key)) {x.value = v; return; }
		first = new Node(k,v,first);
		this.size ++;
	}
	
	public Value get(Key k) {
		for(Node x = first; x != null; x = x.next)
			if(k.equals(x.key)) return x.value;
		return null;
	}
	
	public boolean contains(Key k) {return get(k) != null;}
	
	public boolean isEmpty() { return this.size == 0;}
	
	public int size(){ return this.size; }
	
	Iterable<Key> keys() {
		Queue<Key> queue = new Queue<Key>();
		for(Node x = first; x != null; x = x.next)
			queue.enqueue(x.key);
		return queue;
	}
	
	public void delete(Key k) {
		first = delete(k, first);
	}
	
	private Node delete(Key k, Node x) {
		if(x == null) return null;
		if(k.equals(x.key)) { this.size--; return x.next; }
		x.next = delete(k, x.next);
		return x;
	}
}
