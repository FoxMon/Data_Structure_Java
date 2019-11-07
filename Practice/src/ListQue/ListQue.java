package ListQue;

import java.util.NoSuchElementException;

public class ListQue<E> {
	private Node<E> front, rear;
	private int size;
	
	public ListQue() {
		front = rear = null;
		size = 0;
	}
	
	public int size() { return size; }
	public boolean isEmpty() { return (size == 0); }
	
	public void add(E newItem) {
		Node newNode = new Node(newItem, null);
		
		if(isEmpty()) {
			front = newNode;
		} else {
			rear.setNext(newNode);
		}
		
		rear = newNode;
		size++;
	}
	
	public E remove() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		
		E frontItem = front.getItem();
		front = front.getNext();
		size--;
		
		if(isEmpty()) {
			rear = null;
		}
		
		return frontItem;
	}
	
	public static void main(String[] args) {
		ListQue<String> que = new ListQue<String>();
	}
}
