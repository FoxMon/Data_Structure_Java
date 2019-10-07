import java.util.EmptyStackException;

public class ArrayStack<E> {
	private E s[]; // ������ ���� �迭
	private int top; // ������ top �׸��� �迭 ���� �ε���
	
	public ArrayStack() { // ���� ������
		s = (E[]) new Object[1]; // �ʱ⿡ ũ�Ⱑ 1�� �迭 ����
		top = -1;
	}
	
	public int size() { // ���ÿ� �ִ� �׸� ���� ����
		return top + 1; 
	}
	
	public boolean isEmpty() { // ������ empty�̸� true����
		return (top == -1);
	}
	
	public E peek() { // ������ top �׸��� ���븸�� ����
		if(isEmpty()) {
			throw new EmptyStackException(); // underflow �� ���α׷� ����
		}
		
		return s[top];
	}
	
	public void resize(int newSize) {
		Object[] t = new Object[newSize];
		
		for(int i = 0; i < s.length; i++) { // stack����
			t[i] = s[i]; // s�� t�� ����
		}
		
		s = (E[])t; // �ٽ� t�� s��
	}
	
	public void push(E newItem) { // push���� ���� �ױ�
		if(size() == s.length) { // ������ �� á���� 2��� �ø�
			resize(2*s.length);
		}
		
		s[++top] = newItem; // ���ο� �׸� push
	}
	
	public E pop() { // pop���� stack�� top�� ����� ��ȯ
		if(isEmpty()) { // ��������� ����ó��
			throw new EmptyStackException();
		}
		
		E item = s[top]; // ���ο� ������ ��ȯ�� ������ �ӽ� ����
		s[top--] = null; // null�ְ� top�ε��� ����
		
		if(size() > 0 && size() == s.length / 4) { // �迭�� ������� ���ٸ�
			resize(s.length / 2);
		}
		
		return item;
	}
	
	public void print() {
		for(int i = 0; i < size(); i++) {
			System.out.print(s[i] + " ");
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		ArrayStack<String> stack = new ArrayStack<String>(); // StringŸ���� ������ ���ð�ü ����
		
		stack.push("apple");
		stack.push("orange");
		stack.push("cherry");
		stack.push("pear");
		stack.print();
		System.out.println(stack.pop());
		stack.print();
	}
}
