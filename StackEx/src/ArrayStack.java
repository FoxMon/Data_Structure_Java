import java.util.EmptyStackException;

public class ArrayStack<E> {
	private E s[]; // 스택을 위한 배열
	private int top; // 스택의 top 항목의 배열 원소 인덱스
	
	public ArrayStack() { // 스택 생성자
		s = (E[]) new Object[1]; // 초기에 크기가 1인 배열 생성
		top = -1;
	}
	
	public int size() { // 스택에 있는 항목 수를 리턴
		return top + 1; 
	}
	
	public boolean isEmpty() { // 스택이 empty이면 true리턴
		return (top == -1);
	}
	
	public E peek() { // 스택의 top 항목의 내용만을 리턴
		if(isEmpty()) {
			throw new EmptyStackException(); // underflow 시 프로그램 종료
		}
		
		return s[top];
	}
	
	public void resize(int newSize) {
		Object[] t = new Object[newSize];
		
		for(int i = 0; i < s.length; i++) { // stack복사
			t[i] = s[i]; // s를 t로 복사
		}
		
		s = (E[])t; // 다시 t를 s로
	}
	
	public void push(E newItem) { // push연산 스택 쌓기
		if(size() == s.length) { // 스택이 꽉 찼으면 2배로 늘림
			resize(2*s.length);
		}
		
		s[++top] = newItem; // 새로운 항목 push
	}
	
	public E pop() { // pop연산 stack의 top을 지우고 반환
		if(isEmpty()) { // 비어있으면 예외처리
			throw new EmptyStackException();
		}
		
		E item = s[top]; // 새로운 아이템 반환할 변수에 임시 저장
		s[top--] = null; // null넣고 top인덱스 줄임
		
		if(size() > 0 && size() == s.length / 4) { // 배열이 빈공간이 많다면
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
		ArrayStack<String> stack = new ArrayStack<String>(); // String타입을 가지는 스택객체 생성
		
		stack.push("apple");
		stack.push("orange");
		stack.push("cherry");
		stack.push("pear");
		stack.print();
		System.out.println(stack.pop());
		stack.print();
	}
}
