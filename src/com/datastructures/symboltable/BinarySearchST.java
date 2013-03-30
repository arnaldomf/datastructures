package com.datastructures.symboltable;

import com.datastructures.queue.Queue;

public class BinarySearchST <Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] values;
	private int N;
	
	@SuppressWarnings("unchecked")
	public BinarySearchST() {
		keys = (Key[]) new Comparable[1];
		values = (Value[]) new Object[1];
		N = 0;
	}
	
	public int size() { return N; }
	
	public int size(Key lo, Key hi) {
		if(lo.compareTo(hi) > 0) {return 0;}
		if(contains(hi))
			return rank(hi) - rank(lo) + 1;
		return rank(hi) - rank(lo);
		
	}
	
	public boolean contains(Key k) {
		return get(k) != null;
	}
	
	public int rank(Key k) { return rankBinarySearch(0, size() - 1, k); }
	
	public Key floor(Key k) {
		int idx = rank(k);
		if(idx < N && k.compareTo(keys[idx]) == 0) return keys[idx];
		if(idx == 0) return null;
		return keys[--idx];
	}
	
	public Key ceiling(Key k) {
		int idx = rank(k);
		if(idx == N) return null;
		else return keys[idx];
	}
	
	public void put(Key k, Value v) {
		if(size() == 0) { keys[0] = k; values[0] = v; N++; return; }
		int idx = rank(k);
		
		if(idx < N && k.compareTo(keys[idx]) == 0) { values[idx] = v; return; }
		
		if(size() == keys.length) resize(keys.length * 2);
		
		if(idx >= N) {keys[idx] = k; values[idx] = v; N++; return; }
		Key temp_k1 = k;
		Value temp_v1 = v;
		for(int i=idx; i< size() + 1; i++) {
			Key temp_k2 = keys[i];
			Value temp_v2 = values[i];
			keys[i] = temp_k1;
			values[i] = temp_v1;
			temp_k1 = temp_k2;
			temp_v1 = temp_v2;
		}
		N++;
	}
	
	public Value get(Key k) {
		if(size() == 0) return null;
		int idx = rank(k);
		if(!k.equals(keys[idx])) return null;
		return values[idx];
	}
	
	public void delete(Key k) {
		if(size() == 0) return;
		int idx = rank(k);
		if(keys[idx].compareTo(k) != 0) return;
		for(int i = idx; i < N - 1; i++){
			keys[i] = keys[i+1];
			values[i] = values[i+1];
		}
		keys[N-1] = null;
		values[N-1] = null;
		N --;
		if(size() <= keys.length/4) resize(keys.length/2);
	}
	
	public void deleteMax() { delete(max()); }
	public void deleteMin() { delete(min()); }
	
	public Key select(int idx) {
		if(size() == 0 || idx < 0 || idx >= size()) return null;
		return keys[idx];
	}
	
	public Key max() { return keys[size() - 1]; }
	
	public Key min() { return keys[0]; }
	
	public Iterable<Key> keys() {
		Queue<Key> q = new Queue<Key>();
		for(Key k : keys) q.enqueue(k);
		return q;
	}
	
	public Iterable<Key> keys(Key lo, Key hi) {
		if(lo.compareTo(hi)>0) return null;
		Queue<Key> q = new Queue<Key>();
		int s = size(lo, hi);
		int idx = rank(lo);
		for(int i = idx; i<s; i++)
			q.enqueue(keys[i]);
		return q;
	}
	
	private int rankBinarySearch(int lo, int hi, Key k) {
		if (keys.length == 0) return 0;
		if(lo > hi) return lo;
		int mid = lo + (hi - lo)/2;
		if (keys[mid].compareTo(k) == 0) return mid;
		else if (k.compareTo(keys[mid]) < 0) return rankBinarySearch(lo, mid - 1, k);
		else return rankBinarySearch(mid+1, hi, k);
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int max) {
		Key[] tempKey = (Key[]) new Comparable[max];
		Value[] tempVal = (Value[]) new Object[max];
		for(int i=0; i < N; i++){
			tempKey[i] = keys[i];
			tempVal[i] = values[i];
		}
		keys = tempKey;
		values = tempVal;
	}
	
	public static void main(String[] args) {
		BinarySearchST<String, Integer> st = new BinarySearchST<>();
		st.put("S", 10);
		st.put("E", 1);
		st.put("A", 20);
		st.put("R", 15);
		st.put("C", 21);
		st.put("H", 3);
		
		System.out.println(st.rank("C"));
		System.out.println(st.rank("B"));
		System.out.println(st.rank("Z"));
		System.out.println(st.contains("A"));
		System.out.println(st.contains("S"));
		System.out.println(st.contains("C"));
		System.out.println(st.contains("E"));
		
		System.out.println(st.contains("P"));
		System.out.println(st.contains("Z"));
		System.out.println(st.contains("B"));
		System.out.println(st.size("A", "Z"));
		for(String k : st.keys("B", "Z"))
			System.out.println(k);
		System.out.println("------");
		System.out.println(st.floor("A"));
		System.out.println(st.floor("B"));
		System.out.println(st.floor("C"));
		System.out.println(st.floor("D"));
		System.out.println(st.floor("R"));
		System.out.println(st.floor("S"));
		System.out.println(st.floor("Z"));
	}
}
