package com.datastructures.symboltable;

public class BinarySearchST <Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] values;
	private int N;
	
	@SuppressWarnings("unchecked")
	public BinarySearchST() {
		keys = (Key[]) new Object[1];
		values = (Value[]) new Object[1];
		N = 0;
	}
	
	public int size() { return N; }
	
	public int rank(Key k) { return rankBinarySearch(0, size() - 1, k); }
	
	public Value get(Key k) {
		if(size() == 0) return null;
		int idx = rank(k);
		if(!k.equals(keys[idx])) return null;
		return values[idx];
	}
	
	private int rankBinarySearch(int lo, int hi, Key k) {
		if (keys.length == 0) return 0;
		if(lo >= hi) return lo;
		int mid = lo + (hi - lo)/2;
		if (keys[mid].compareTo(k) == 0) return mid;
		else if (k.compareTo(keys[mid]) < 0) return rankBinarySearch(lo, mid - 1, k);
		else return rankBinarySearch(mid+1, hi, k);
	}
}
