package ArrList;

import java.util.NoSuchElementException;

public class ArrList<E> {
	private E[] list;
	private int size;
	
	public ArrList() {
		list = (E[]) new Object[1];
		size = 0;
	}
	
	public void resize(int newSize) {
		Object[] temp = new Object[newSize];
		
		for(int i = 0; i < size; i++) {
			temp[i] = list[i];
		}
		
		list = (E[]) temp;
	}
	
	public E peek(int index) {
		if(size == 0) {
			throw new NoSuchElementException();
		}
		
		return list[index];
	}
	
	public void insert(E item, int index) {
		if(size == list.length) {
			resize(2 * list.length);
		}
		
		for(int i = size - 1; i >= index; i--) {
			list[i+1] = list[i];
		}
		
		list[index] = item;
		size++;
	}
	
	public void insertLast(E item) {
		if(size == list.length) {
			resize(2 * list.length);
		}
		
		list[size++] = item;
	}
	
	public E delete(int index) {
		if(size == 0) {
			throw new NoSuchElementException();
		}
		
		E item = list[index];
		
		for(int i = index; i < size; i++) {
			list[i] = list[i + 1];
		}
		
		size--;
		
		if(size > 0 && size == list.length / 4) {
			resize(list.length / 2);
		}
		
		return item;
	}
	
	public static void main(String[] args) {
		ArrList<String> list = new ArrList<String>();
	}
}