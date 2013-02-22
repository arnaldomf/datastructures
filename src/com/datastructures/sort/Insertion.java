package com.datastructures.sort;

public class Insertion {
	@SuppressWarnings("unchecked")
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	@SuppressWarnings("rawtypes")
	private static void exch(Comparable[] a, int i, int j){
		Comparable sw = a[i];
		a[i] = a[j];
		a[j] = sw;
	}
	
	@SuppressWarnings("rawtypes")
	public static boolean isSorted(Comparable[] array){
		for (int i=1; i<array.length; i++){
			if(less(array[i],array[i-1])){
				return false;
			}
		}
		return true;
	}
	
	public static void sort(Comparable[] array) {
		for (int i=0; i<array.length; i++){
			int j = i - 1;
			while (j >= 0 && less(array[j+1], array[j])){
				exch(array, j, j+1);
				j--;
			}
		}
	}
}
