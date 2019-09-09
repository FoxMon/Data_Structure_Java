import java.util.NoSuchElementException;

public class SingleList<E> {
	protected Node head; // ���Ḯ��Ʈ�� ù ���
	private int size;
	
	public SingleList() {
		head = null;
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public int search(E target) { // target Ž��
		Node temp = head;
		
		for(int i = 0; i < size; i++) {
			if(target == temp.getItem()) {
				return i;
			}
			
			temp = temp.getNext();
		}
		
		
		return -1; // Ž�� ���� �� -1��ȯ
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
		
		Node delete = temp.getNext();
		
		temp.setNext(delete.getNext());
		delete.setNext(null);
		size--;
	}
	
	public void print() { // ���� �迭�� ��Ȳ ���
		for(int i = 0; i < size; i ++) {
			System.out.print(head.getItem() + " ");

			head = head.getNext();
		}
	}
}
