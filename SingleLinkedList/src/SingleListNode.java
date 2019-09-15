import java.util.NoSuchElementException;

public class SingleListNode<E> {
	private int size; // ����� ����� ����
	protected Node<E> head; // ù ���۷����� ����Ŵ
	protected Node<E> last; // ���� ���۷����� ����Ŵ
	
	public SingleListNode() {
		size = 0; // ó�� ����� ����� ���� 0
		head = null; // ó���� ����Ű�� ���۷��� -> null
	}
	
	public void insertFront(E coeNum, int balance) { // ù�κп� ��� ����
		head = new Node(coeNum, balance, head);
		size++; // ����� �� ����
	}
	
	public void insertAfter(E coeNum, int balance, Node<E> temp) { // �߰��� ��� ����
		temp.setNext(new Node(coeNum, balance, temp));
		size++;
	}
	
	public void insertLast(E coeNum, int balance) {
		last = new Node(coeNum, balance, null);
		size++;
	}
	
	public boolean isEmpty() { // �� ��ü�� ������� Ȯ��
		if(size == 0) { // ����� ����� ������ 0�̸� true
			return true;
		}
		
		return false; // �ƴϸ� false
	}
	
	public void deleteFront() { // ù ��� ����
		if(this.isEmpty()) { // ���������
			throw new NoSuchElementException(); // ����ó����
		}
		
		head = head.getNext(); // head�� ���� ��带 ����Ű���� �� �� ù ����� ���� ��带 ����Ŵ
		size--; // ��尳�� ����
	}
	
	public void deleteFrontAfter(Node<E> temp) { // ù��° ����� ���� ��� ����
		if(temp == null) { // ��尡 ����Ű�� �ִ°� ������
			throw new NoSuchElementException(); // ����ó��
		}
		
		Node delete = temp.getNext();
		
		temp.setNext(delete.getNext()); // ���� ��带 ����Ű�� �ϰ�
		delete.setNext(null); // null�� �־��ش�
		size--;
	}
	
	public int search(int balance) { // ������ �˻�
		Node temp = head;
		
		for(int i = 0; i < size; i++) {
			if(temp != null) {
				if(balance == temp.getBalance()) { // balance�� ������
					return i; // ������ �ε��� ��ȯ
				}
			}
			
			temp = temp.getNext(); // ���� ���� �Ѿ
		}
		
		return -1; // ã�� ���� ��� -1��ȯ
	}
	
	public E plus(Object num1, Object num2) { // ��� ���ϱ�
		Integer rst = (int)num1 + (int)num2;

		return (E)rst;
	}
	
	public Node<E> getNode() {
		return head;
	}
	
	public void reverse() {  // �������� �ٲٱ�
		Node current = head;  // ����
		Node previous = null;  // ����
		Node next = null;  // ����
		  
		while(current != null) {
			next = previous;
			previous = current;
			current = current.getNext();
			previous.setNext(next);
		}
		  
	head = previous;
	}

	public void addNode(Node<E> fx, Node<E> gx) { // fx�Լ��� gx�Լ� ����
		Node fhead = fx;
		Node ghead = gx;
		
		while((fhead.getNext() != null) && (ghead.getNext() != null)) { // 3���� ���� ���� ����
			if(fhead.getBalance() > ghead.getBalance()) { // fx�� �� ū ���
				if(fhead == null) {
					insertFront((E)fhead.getCoeNum(), fhead.getBalance());
					last = head;
				} else {
					insertLast((E)fhead.getCoeNum(), fhead.getBalance());
				}
				fhead = fhead.getNext();
			} else if(fhead.getBalance() < ghead.getBalance()) { // gx�� �� ū���
				if(fhead == null) {
					insertFront((E)ghead.getCoeNum(), ghead.getBalance());
					last = head;
				} else {
					insertLast((E)ghead.getCoeNum(), ghead.getBalance());
				}
				ghead = ghead.getNext();
			} else { // �������
				if(fhead == null) {
					insertFront(plus(fhead.getCoeNum(), ghead.getCoeNum()), fhead.getBalance());
					last = head;
				} else {
					insertLast(plus(fhead.getCoeNum(), ghead.getCoeNum()), fhead.getBalance());
				}
			}
		}
	}
	
	public void print() {
		Node temp = head;
		
		while(temp.getNext() != null) {
			System.out.print(temp.getCoeNum() + "x^" + temp.getBalance() + "+");
			
			temp = temp.getNext();
		}
		System.out.print(temp.getCoeNum() + "x^" + temp.getBalance());
		System.out.println();
	}
}
