package ArrStack;

import java.util.EmptyStackException;

public class ArrStack<E> {
	private E[] stack;
	private int top;
	
	public ArrStack() {
		stack = (E[]) new Object[1];
		top = -1;
	}
	
	public int size() { return (top + 1); }
	public boolean isEmpty() { return (top == -1); }
	
	public void resize(int newSize) {
		Object[] temp = new Object[newSize];
		
		for(int i = 0; i < size(); i++) {
			temp[i] = stack[i];
		}
		
		temp = (E[]) stack;
	}
	
	public E peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		return stack[top];
	}
	
	public void push(E item) {
		if(size() == stack.length) {
			resize(stack.length * 2);
		}
		
		stack[++top] = item;
	}
	
	public E pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		E temp = stack[top];
		stack[top--] = null;
		
		if(size() > 0 && size() == stack.length / 4) {
			resize(stack.length / 2);
		}
		
		return temp;
	}
	
	public static void main(String[] args) {
		ArrStack<String> stack = new ArrStack<String>();
	}
}