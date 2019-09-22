import java.util.NoSuchElementException;

/**
 * ListQueue
 * Practice
 * for Study
 * class ListQueue, add, remove
 */

public class ListQueue<E> {
	private Node<E> front, rear;
	private int size;
	
	public ListQueue() {
		front = rear = null;
		size = 0;
	}
	
	public int size() { // size ��ȯ
		return size;
	}
	
	public boolean isEmpty() { // �׸��� ������
		return (size == 0);
	}
	
	public void add(E item) { // ���ο� ��� �߰�
		Node newNode = new Node(item, null); // �� ��� ����
		
		if(isEmpty()) { // ť�� empty�� front�� newNode�� ����Ű���� �Ѵ�
			front = newNode;
		} else { // rear�� ����Ű�� ���۷����� ��尡 ���ο� ��带 ����Ű���� �Ѵ�
			rear.setNext(newNode);
		}
		
		rear = newNode; // �׸��� rear�� ���ο� ��带 ����Ű��  ���۷����� �����Ѵ�
		size++; // size�߰�
	}
	
	public E remove() { // �׸� ����
		if(isEmpty()) { // ����ִٸ� ����ó��
			throw new NoSuchElementException();
		}
		
		E frontItem = front.getItem(); // �ӽ÷� ����
		front = front.getNext(); // ���� ��带 ����Ű�� �����μ�, node����
		size--; // �׸�� 1 ����
		
		if(isEmpty()) { // ť�� empty�̸� rear = null
			rear = null;
		}
		
		return frontItem;
	}
	
	public static void main(String[] args) {
		ListQueue<String> listQ = new ListQueue<String>(); // ����Ʈ ť ��ü ����
		//���� ���� �˾Ƽ��ϼ�
	}
}
