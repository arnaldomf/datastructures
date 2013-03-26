package com.datastructures.symboltable;

// Unordered SymbolTable

public class SymbolTable<Key, Value> {
	
	private class Node<Key, Value> {
		public Node<Key, Value> next;
		public Value value;
		public Key key;
	}
	private Node<Key, Value> first;
	
	public SymbolTable(){
	}
	
	public void put(Key k, Value v) {
		if (first == null) {
			first = new Node<Key, Value>();
			first.key = k;
			first.value = v;
			first.next = null;
		}
		else {
			Node<Key, Value> current = first;
			while(true) {
				if (current.key.equals(k)) {
					current.value = v;
					break;
				}
				if (current.next == null){
					current.next = new Node<Key,Value>();
					current.next.key = k;
					current.next.value = v;
					break;
				}
				else current = current.next;
			}
		}
	}
}
