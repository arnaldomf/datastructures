package com.datastructures.sort;

public class Selection {
	
	
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
	public static void sort(Comparable[] array){
		for (int i= 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				if(less(array[j], array[i])){
					exch(array, i, j);
				}
			}
		}
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

}
