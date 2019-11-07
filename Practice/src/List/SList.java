package List;

import java.util.NoSuchElementException;

public class SList<E> {
	private Node head;
	private int size;
	
	public SList() {
		head = null;
		size = 0;
	}
	
	public int size() { return size; }
	public boolean isEmpty() { return ( size == 0 ); }
	
	public int search(E target) {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		
		Node temp = head;
		
		for(int i = 0; i < size; i++) {
			if(temp.getItem() == target) {
				return i;
			}
			
			temp = temp.getNext();
		}
		
		return -1;
	}
	
	public void insertFront(E item) {
		head = new Node(item, head);
		size++;
	}
	
	public void insertAfter(E item, Node temp) {
		temp.setNext(new Node(item, temp.getNext()));
		size++;
	}
	
	public void deleteFront() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		
		head = head.getNext();
		size--;
	}
	
	public void deleteAfter(Node p) {
		if(p == null) {
			throw new NoSuchElementException();
		}
		
		Node temp = p.getNext();
		p.setNext(temp.getNext());
		temp.setNext(null);
		size--;
	}
	
	public static void main(String[] args) {
		SList<String> list = new SList<String>();
	}
}