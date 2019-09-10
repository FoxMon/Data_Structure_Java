import java.util.NoSuchElementException;

public class SingleList<E> {
	private int size;
	protected Node head; // 연결리스트의 첫 노드
	
	public SingleList() {
		head = null;
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public void insertFront(E item) { // 연결리스트 맨 앞에 삽입
		head = new Node(item, head);
		size++;
	}
	
	public void insertAfter(E item, Node temp) { // 연결리스트 temp 바로 뒤에 삽입
		temp.setNext(new Node(item, temp.getNext()));
		size++;
	}
	
	public void deleteFront() { // 리스트의 첫 노드 삭제
		if(size == 0) {
			throw new NoSuchElementException();
		}
		
		head = head.getNext();
		size--;
	}
	
	public void deleteAfter(Node temp) { // temo가 가리키는 리스트의 다음노드 삭제
		if(temp == null) {
			throw new NoSuchElementException();
		}
		
		Node d = temp.getNext();
		
		temp.setNext(d.getNext());
		d.setNext(null);
		size--;
	}
	
	public int search(E target) { // target 탐색
		Node temp = head;
		
		for(int i = 0; i < size; i++) {
			if(temp != null) {
				if(target == temp.getItem()) {
					return i;
				}
			}
			
			temp = temp.getNext();
		}
		
		return -1; // 탐색 실패 시 -1반환
	}
	
	public void print() { // 현재 배열의 상황 출력
		Node temp = head;
		for(int i = 0; i < size; i ++) {
			System.out.print(temp.getItem() + " ");

			temp = temp.getNext();
		}
	}
}
