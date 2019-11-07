package ListQueue;

import java.util.NoSuchElementException;

public class ListQue<E> {
	private Node<E> front;
	private Node<E> rear;
	private int size;
	
	public ListQue() {
		front = rear = null;
		size = 0;
	}
	
	public int size() { return size; }
	public boolean isEmpty() { return (size == 0); }
	
	public void add(E item) {
		Node newNode = new Node(item, null);
		
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
		
		E temp = front.getItem();
		front = front.getNext();
		size--;
		
		return temp;
	}
	
	public static void main(String[] args) {
		
	}
}