import java.util.NoSuchElementException;

public class SingleList<E> {
	private int size;
	protected Node head; // ���Ḯ��Ʈ�� ù ���
	
	public SingleList() {
		head = null;
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public void insertFront(E item) { // ���Ḯ��Ʈ �� �տ� ����
		head = new Node(item, head);
		size++;
	}
	
	public void insertAfter(E item, Node temp) { // ���Ḯ��Ʈ temp �ٷ� �ڿ� ����
		temp.setNext(new Node(item, temp.getNext()));
		size++;
	}
	
	public void deleteFront() { // ����Ʈ�� ù ��� ����
		if(size == 0) {
			throw new NoSuchElementException();
		}
		
		head = head.getNext();
		size--;
	}
	
	public void deleteAfter(Node temp) { // temo�� ����Ű�� ����Ʈ�� ������� ����
		if(temp == null) {
			throw new NoSuchElementException();
		}
		
		Node d = temp.getNext();
		
		temp.setNext(d.getNext());
		d.setNext(null);
		size--;
	}
	
	public int search(E target) { // target Ž��
		Node temp = head;
		
		for(int i = 0; i < size; i++) {
			if(temp != null) {
				if(target == temp.getItem()) {
					return i;
				}
			}
			
			temp = temp.getNext();
		}
		
		return -1; // Ž�� ���� �� -1��ȯ
	}
	
	public void print() { // ���� �迭�� ��Ȳ ���
		Node temp = head;
		for(int i = 0; i < size; i ++) {
			System.out.print(temp.getItem() + " ");

			temp = temp.getNext();
		}
	}
}
