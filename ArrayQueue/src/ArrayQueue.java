import java.util.NoSuchElementException;

/**
 * ArrayQueue
 * Practice
 * for Study
 * ArrayQueue class, add, remove, resize
 */

public class ArrayQueue<E> {
	private E[] q; // ť�� ���� �迭
	private int front; // ������ ������
	private int rear; // �� ������ ������
	private int size; // ť�� �׸� ��

	public ArrayQueue() {
		q = (E[]) new Object[2]; // �ʱ� �迭ũ�� 2
		front = rear = size = 0;
	}
	
	public int size() { // ť�� �ִ� �׸��� ���� ����
		return size;
	}
	
	public boolean isEmpty() { // ť�� ����ִ°�?
		return (size == 0);
	}
	
	public void resize(int newSize) { // ������ ������
		Object []t = new Object[newSize];
		
		for(int i = 1, j = front + 1; i < size + 1; i++, j++) {
			t[i] = q[j]; // ����
		}
		
		front = 0; // remove�� ����Ǹ鼭 front�� ��ġ�� �ٲ���� ���ɼ��� �����ϱ�, front�� �ٽ� 0���� ������
		rear = size;
		q = (E[])t;
	}
	
	public void add(E item) { // �׸� �߰�
		if((rear + 1) % q.length == front) {
			resize(q.length *2);
		}
		
		rear = (rear + 1) % q.length;
		q[rear] = item;
		size++;
	}
	
	public E remove() { // ť�� �׸� ����
		if(isEmpty()) { // ��������� ����ó��
			throw new NoSuchElementException();
		}
		
		front = (front + 1) % q.length;
		E item = q[front]; // �׸� �ӽ����� ��
		q[front] = null; // ����
		size--;
		
		if(size > 0 && size == q.length / 4) { // 1/4�� �����ϰ� �ִٸ�
			resize(q.length / 2); // ť�� ũ�� 1/2�� ��ҽ�Ŵ
		}
		
		return item; // �׸���
	}
	
	public static void main(String[] args) {
		ArrayQueue<String> queue = new ArrayQueue<String>(); // ť ��ü ����
		
		// �߰�, ����, �˾Ƽ��ϼ�
	}
}