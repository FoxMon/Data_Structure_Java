import java.util.NoSuchElementException;

public class SingleList<E> {
	protected Node head;
	protected Node last;
	private int size;
	
	public SingleList() {
		head = null;
		last = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return ( size == 0 );
	}
	
	public int search(E target) {
		Node p = head;
		
		for(int i = 0; i < size; i++) {
			if(target == p.getItem()) {
				return i;
			}
			
			p = p.getNext();
		}
		
		return -1;
	}
	
	public void insertFront(E newItem, int aux) {
		head = last = new Node(newItem, head, aux);
		size++;
	}
	
	public void insertAfter(E newItem, int aux, Node temp) {
		last = new Node(newItem, temp.getNext(), aux);
		temp.setNext(last);
		size++;
	}
	
	public void deleteFront() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		
		head = head.getNext();
		size--;
	}
	
	public void deleteAfter(Node temp) {
		if(temp == null) {
			throw new NoSuchElementException();
		}
		
		Node p = temp.getNext();
		temp.setNext(p.getNext());
		p.setNext(null);
		size--;
	}
	
	public void print() {
		if(isEmpty()) {
			System.out.println("List is empty...");
		}
		
		Node<E> p = head;
		
		do {
			System.out.println(((int)p.getItem() > 0 ? "+" : " ") + p.getItem() + (p.getAux() == 0 ? "" : "x^" + p.getAux()) + " ");
			
			p = p.getNext();
		} while(p != null);
		
		System.out.println();
	}
	
	public static SingleList<Integer> merge(SingleList<Integer> f, SingleList<Integer> g){
		Node<Integer> p = f.head;
		Node<Integer> q = g.head;
		SingleList<Integer> s = new SingleList<Integer>();
		
		while(p != null || q != null) {
			if(p != null || q != null) {
				s.insertAfter(q.getItem(), q.getAux(), s.last);
				q = q.getNext();
			} else if(q == null) {
				
			} else if(p.getAux() > q.getAux()) {
				if(s.isEmpty())
					s.insertFront(p.getItem(), p.getAux());
				else
					s.insertAfter(p.getItem(), p.getAux(), s.last);
				p = p.getNext();
			} else if(p.getAux() < q.getAux()) {
				if(s.isEmpty())
					s.insertFront(q.getItem(), q.getAux());
				else
					s.insertAfter(q.getItem(), q.getAux(), s.last);
				q = q.getNext();
			} else {
				if(s.isEmpty())
					s.insertFront(p.getItem() + q.getItem(), p.getAux());
				else
					s.insertAfter(p.getItem() + q.getItem(), p.getAux(), s.last);
				p = p.getNext();
				q = q.getNext();
			}
		}
		
		return s;
	}
	
	public static void main(String[] args) {
		SingleList<Integer> s = new SingleList<Integer>();
		
		s.insertFront(-9, 0);
		s.insertFront(-2,2);
		s.insertFront(7,3);
		s.insertFront(3,6);
		s.print();
		
		SingleList<Integer> t = new SingleList<Integer>();	// 연결 리스트 객체 t 생성
		
//		t.insertFront(1, 0);
//		t.insertFront(6, 1);
//		t.insertFront(6, 2);
		t.insertFront(-4, 4);;
		t.insertFront(-2, 6);
		t.print();
		
		SingleList<Integer> res = merge(s, t);
		res.print();
	}
}
