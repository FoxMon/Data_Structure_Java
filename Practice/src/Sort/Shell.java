package Sort;

import java.lang.Comparable;

public class Shell {
	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 4;
		
		while(h>=1) {
			for(int i = h; i < N; i++) {
				for(int j = i; j >= h && isless(a[j], a[j-h]); j -= h) {
					swap(a, j, j - h);
				}
			}
			
			h /= 3;
		}
	}
	
	public static void swap(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static boolean isless(Comparable i, Comparable j) {
		return (i.compareTo(j) < 0);
	}
}
