package SlistStack;

import java.util.EmptyStackException;

public class SlistStack<E> {
	private Node<E> top;
	private int size;
	
	public SlistStack() {
		top = null;
		size = 0;
	}
	
	public int size() { return size; }
	public boolean isEmpty() { return (size == 0); }
	
	public E peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		return top.getItem();
	}
	
	public void push(E item) {
		Node newNode = new Node(item, top);
		top = newNode;
		size++;
	}
	
	public E pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		E temp = top.getItem();
		top = top.getNext();
		size--;
		
		return temp;
	}
	
	public static void main(String[] args) {
		SlistStack<String> stack = new SlistStack<String>();
	}
}