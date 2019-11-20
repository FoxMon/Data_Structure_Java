package Huffman;

public class Huffman {
	private Entry[] a;
	private int n;
	
	public Huffman(Entry[] harray, int initialSize) {
		a = harray;
		n = initialSize;
	}
	
	private boolean greater(int i, int j) { return a[i].getKey() > a[j].getKey(); }
	private int size() { return n; }
	
	private void swap(int i, int j) {
		Entry temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private void downheap(int i) {
		while(2 * i <= n) {
			int k = i * 2;
			
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
	
	private void upheap(int i) {
		while(i > 1 && greater(i/2, i)) {
			swap(i/2, i);
			i = i/2;
		}
	}
	
	public void insert(int frequency, String word, Entry left, Entry right, String code) {
		Entry temp = new Entry(frequency, word, left, right, code);
		a[++n] = temp;
		upheap(n);
	}
	
	public void insert(Entry temp) {
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
	
	public void createheap() {
		for(int i = n/2; i > 0; i--) {
			downheap(i);
		}
	}
	
	public Entry createTree() {
		while(size() > 1) {
			Entry e1 = deleteMin();
			Entry e2 = deleteMin();
			Entry temp = new Entry(e1.getKey() + e2.getKey(), e1.getValue() + e2.getValue(), e1, e2, " ");
			insert(temp);
		}
		
		return deleteMin();
	}
	
	public void print() {
		for(int i = 1; i < n + 1; i++) {
			System.out.print("[" + a[i].getKey() + " " + a[i].getValue() + "] ");
		}
		System.out.println();
	}
	
	public void preorder(Entry n) {
		if(n == null) {
			return;
		}
		
		if(n.getLeft() != null) {
			n.getLeft().setCode(n.getCode() + "0");
			preorder(n.getLeft());
		}
		
		if(n.getRight() != null) {
			n.getRight().setCode(n.getCode() + "1");
			preorder(n.getRight());	
		}
		
		if(n.getLeft() == null && n.getRight() == null) {
			System.out.print(n.getValue() + ":" + n.getCode() + "  ");
		}
	}
	
	public static void main(String[] args) {
		Entry[] arr;
		arr = new Entry[7];
		arr[1] = new Entry(60, "a", null, null, null); arr[2] = new Entry(20, "b", null, null, null);
		arr[3] = new Entry(30, "c", null, null, null); arr[4] = new Entry(35, "d", null, null, null);
		arr[5] = new Entry(40, "e", null, null, null); arr[6] = new Entry(90, "f", null, null, null);
		
		Huffman hArr = new Huffman(arr, 6);
		
		System.out.println("최소힙 만들기 전");
		hArr.print();
		
		System.out.println("최소힙");
		hArr.createheap();
		hArr.print();
		
		System.out.println("허프만 코드");
		Entry root = hArr.createTree();
		hArr.preorder(root);
		System.out.println();
	}
}