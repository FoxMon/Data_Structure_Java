package PriorityQueue;

public class BHeap<Key extends Comparable<Key>, Value> {
	private Entry[] a;
	private int n;
	
	public BHeap(Entry[] harray, int initialSize) {
		a = harray;
		n = initialSize;
	}
	
	public int size() { return n; }
	
	public boolean greater(int i, int j) {
		return a[j].getKey().compareTo(a[i].getKey()) < 0;
	}
	
	public void swap(int i, int j) {
		Entry temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public void downheap(int i) {
		while(2*i <= n) {
			int k = 2*i;
			
			if(k < n && greater(k, k+1)) {
				k++;
			}
			
			if(!greater(i, k)) {
				break;
			}
			
			swap(i, k);
			i = k;
		}
	}
	
	public void upheap(int j) {
		while(j > 1 && greater(j/2, j)) {
			swap(j/2, j);
			j = j/2;
		}
	}
	
	public void createHeap() {
		for(int i = n/2; i > 0; i--) {
			downheap(i);
		}
	}
	
	public void insert(Key newKey, Value newValue) {
		Entry temp = new Entry(newKey, newValue);
		a[++n] = temp;
		upheap(n);
	}
	
	public Entry deleteMin() {
		Entry min = a[1];
		swap(1, n--);
		a[n+1] = null;
		downheap(1);
		
		return min;
	}
}