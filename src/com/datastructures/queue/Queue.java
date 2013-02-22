package com.datastructures.queue;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
	@SuppressWarnings("unchecked")
	private Item[] array = (Item[]) new Object[1];
	private int N = 0;
	private int tail = 0;
	private int head = 0;
	
	public int size() { return N; }
	public boolean isEmpty() { return N == 0; }
	
	@SuppressWarnings("unchecked")
	private void resize(int max){
		Item[] temp = (Item[]) new Object[max];
		int current = head;
		for (int i = 0; i< N; i++) {
			temp[i] = array[current];
			current = (current + 1) % array.length;
		}
		
		tail = N - 1;
		head = 0;
		array = temp;
	}
	
	public void enqueue(Item item){
		if (N == array.length) resize(array.length * 2);
		tail = (tail + 1) % array.length;
		array[tail] = item;
		N++;
	}
	
	public Item dequeue(){
		Item item = array[head];
		if (!isEmpty()){
			array[head] = null;
			head = (head + 1) % array.length;
			N--;
			if (N > 0 && N == array.length/4) resize(array.length/2);
		}
		return item;
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<Item> {

		private int cur = head;
		private int count = 0;
		@Override
		public boolean hasNext() {
			return count != N;
		}

		@Override
		public Item next() {
			Item item = array[cur];
			cur = (cur + 1) % array.length;
			count ++;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
