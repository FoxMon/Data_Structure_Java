package Huffman;

import PriorityQueue.Entry;

public class Huffman {
	private Entry[] a;
	private int size;
	
	public Huffman(Entry[] harray, int initialSize) {
		a = harray;
		size = initialSize;
	}
	
	public int size() { return size; }
	
	public void swap(int i, int j) {
		Entry temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private boolean greater(int i, int j) {
		return a[i].getKey() > a[j].getKey();
	}
	
	public void downheap(int i) {
		while(2*i <= size) {
			int k = 2*i;
			
			if(k < size && greater(k, k+1)) {
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
	
	public Entry deleteMin() {
		Entry min = a[1];
		
		swap(1, size--);
		a[size+1] = null;
		downheap(1);
		
		return min;
	}
	
	public void insert(Entry temp) { // ���ο� �׸� ���� // Entry ����
		a[++size] = temp; // ���ο� Ű( �׸� )�� �迭 ������ �׸� ������ ����
		upheap(size); // ���� �ö󰡸� �� �Ӽ��� ȸ����Ŵ
	}
	
	public Entry createTree() {
		while(size() > 1) {
			Entry e1 = deleteMin();
			Entry e2 = deleteMin();
			Entry temp = new Entry((e1.getKey() + e2.getKey(), e1.getValue() + e2.getValue(), e1, e2, " ");
		}
		
		return deleteMin();
	}	
}
