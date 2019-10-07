import java.util.NoSuchElementException;

/**
 * ArrayQueue
 * Practice
 * for Study
 * ArrayQueue class, add, remove, resize
 */

public class ArrayQueue<E> {
	private E[] q; // 큐를 위한 배열
	private int front; // 가져올 데이터
	private int rear; // 맨 마지막 데이터
	private int size; // 큐의 항목 수

	public ArrayQueue() {
		q = (E[]) new Object[2]; // 초기 배열크기 2
		front = rear = size = 0;
	}
	
	public int size() { // 큐에 있는 항목의 수를 리턴
		return size;
	}
	
	public boolean isEmpty() { // 큐가 비어있는가?
		return (size == 0);
	}
	
	public void resize(int newSize) { // 사이즈 재조정
		Object []t = new Object[newSize];
		
		for(int i = 1, j = front + 1; i < size + 1; i++, j++) {
			t[i] = q[j]; // 복사
		}
		
		front = 0; // remove가 진행되면서 front의 위치가 바뀌었을 가능성이 있으니까, front를 다시 0에다 설정함
		rear = size;
		q = (E[])t;
	}
	
	public void add(E item) { // 항목 추가
		if((rear + 1) % q.length == front) {
			resize(q.length *2);
		}
		
		rear = (rear + 1) % q.length;
		q[rear] = item;
		size++;
	}
	
	public E remove() { // 큐의 항목 삭제
		if(isEmpty()) { // 비어있으면 예외처리
			throw new NoSuchElementException();
		}
		
		front = (front + 1) % q.length;
		E item = q[front]; // 항목 임시저장 후
		q[front] = null; // 삭제
		size--;
		
		if(size > 0 && size == q.length / 4) { // 1/4만 차지하고 있다면
			resize(q.length / 2); // 큐의 크기 1/2로 축소시킴
		}
		
		return item; // 항목리턴
	}
	
	public static void main(String[] args) {
		ArrayQueue<String> queue = new ArrayQueue<String>(); // 큐 객체 생성
		
		// 추가, 삭제, 알아서하셈
	}
}