package List;

import java.util.NoSuchElementException;

public class DList<E> {
	private DNode head;
	private DNode tail;
	private int size;
	
	public DList() {
		head = new DNode(null, null, null);
		tail = new DNode(null, head, null);
		head.setNext(tail);
		size = 0;
	}
	
	public void insertBefore(E item, DNode p) {
		DNode temp = p.getPrevious();
		DNode newNode = new DNode(item, temp, p);
		p.setPrevious(newNode);
		temp.setNext(newNode);
		size++;
	}
	
	public void insertAfter(E item, DNode p) {
		DNode temp = p.getNext();
		DNode newNode = new DNode(item, p, temp);
		temp.setPrevious(newNode);
		p.setNext(newNode);
		size++;
	}
	
	public void delete(DNode d) {
		if(d == null) {
			throw new NoSuchElementException();
		}
		
		DNode f = d.getPrevious();
		DNode g = d.getNext();
		f.setNext(g);
		g.setPrevious(f);
		size--;
	}
	
	public static void main(String[] args) {
		DList<String> list = new DList<String>();
	}
}
