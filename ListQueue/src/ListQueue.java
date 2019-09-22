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
	
	public int size() { // size 반환
		return size;
	}
	
	public boolean isEmpty() { // 항목이 없는지
		return (size == 0);
	}
	
	public void add(E item) { // 새로운 노드 추가
		Node newNode = new Node(item, null); // 새 노드 생성
		
		if(isEmpty()) { // 큐가 empty면 front가 newNode를 가리키도록 한다
			front = newNode;
		} else { // rear가 가리키는 레퍼런스의 노드가 새로운 노드를 가리키도록 한다
			rear.setNext(newNode);
		}
		
		rear = newNode; // 그리고 rear는 새로운 노드를 가리키록  레퍼런스를 설정한다
		size++; // size추가
	}
	
	public E remove() { // 항목 제거
		if(isEmpty()) { // 비어있다면 예외처리
			throw new NoSuchElementException();
		}
		
		E frontItem = front.getItem(); // 임시로 저장
		front = front.getNext(); // 다음 노드를 가리키게 함으로서, node삭제
		size--; // 항목수 1 감소
		
		if(isEmpty()) { // 큐가 empty이면 rear = null
			rear = null;
		}
		
		return frontItem;
	}
	
	public static void main(String[] args) {
		ListQueue<String> listQ = new ListQueue<String>(); // 리스트 큐 객체 생성
		//이후 연산 알아서하셈
	}
}
