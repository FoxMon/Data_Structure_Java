import java.util.NoSuchElementException;

public class SingleListNode<E> {
	private int size; // 저장된 노드의 개수
	protected Node<E> head; // 첫 레퍼런스를 가리킴
	protected Node<E> last; // 다음 레퍼런스를 가리킴
	
	public SingleListNode() {
		size = 0; // 처음 저장된 요소의 개수 0
		head = null; // 처음에 가리키는 레퍼런스 -> null
	}
	
	public void insertFront(E coeNum, int balance) { // 첫부분에 노드 삽입
		head = new Node(coeNum, balance, head);
		size++; // 노드의 수 증가
	}
	
	public void insertAfter(E coeNum, int balance, Node<E> temp) { // 중간에 노드 삽입
		temp.setNext(new Node(coeNum, balance, temp));
		size++;
	}
	
	public void insertLast(E coeNum, int balance) {
		last = new Node(coeNum, balance, null);
		size++;
	}
	
	public boolean isEmpty() { // 현 객체가 비었는지 확인
		if(size == 0) { // 저장된 요소의 개수가 0이면 true
			return true;
		}
		
		return false; // 아니면 false
	}
	
	public void deleteFront() { // 첫 노드 삭제
		if(this.isEmpty()) { // 비어있으면
			throw new NoSuchElementException(); // 예외처리함
		}
		
		head = head.getNext(); // head는 다음 노드를 가리키도록 함 즉 첫 노드대신 다음 노드를 가리킴
		size--; // 노드개수 감수
	}
	
	public void deleteFrontAfter(Node<E> temp) { // 첫번째 노드의 다음 노드 삭제
		if(temp == null) { // 노드가 가리키고 있는게 없으면
			throw new NoSuchElementException(); // 예외처리
		}
		
		Node delete = temp.getNext();
		
		temp.setNext(delete.getNext()); // 다음 노드를 가리키게 하고
		delete.setNext(null); // null을 넣어준다
		size--;
	}
	
	public int search(int balance) { // 차수를 검색
		Node temp = head;
		
		for(int i = 0; i < size; i++) {
			if(temp != null) {
				if(balance == temp.getBalance()) { // balance가 같으면
					return i; // 차수의 인덱스 반환
				}
			}
			
			temp = temp.getNext(); // 다음 노드로 넘어감
		}
		
		return -1; // 찾지 못한 경우 -1반환
	}
	
	public E plus(Object num1, Object num2) { // 계수 더하기
		Integer rst = (int)num1 + (int)num2;

		return (E)rst;
	}
	
	public Node<E> getNode() {
		return head;
	}
	
	public void reverse() {  // 역순으로 바꾸기
		Node current = head;  // 현재
		Node previous = null;  // 이전
		Node next = null;  // 다음
		  
		while(current != null) {
			next = previous;
			previous = current;
			current = current.getNext();
			previous.setNext(next);
		}
		  
	head = previous;
	}

	public void addNode(Node<E> fx, Node<E> gx) { // fx함수와 gx함수 더함
		Node fhead = fx;
		Node ghead = gx;
		
		while((fhead.getNext() != null) && (ghead.getNext() != null)) { // 3가지 경우로 구분 가능
			if(fhead.getBalance() > ghead.getBalance()) { // fx가 더 큰 경우
				if(fhead == null) {
					insertFront((E)fhead.getCoeNum(), fhead.getBalance());
					last = head;
				} else {
					insertLast((E)fhead.getCoeNum(), fhead.getBalance());
				}
				fhead = fhead.getNext();
			} else if(fhead.getBalance() < ghead.getBalance()) { // gx가 더 큰경우
				if(fhead == null) {
					insertFront((E)ghead.getCoeNum(), ghead.getBalance());
					last = head;
				} else {
					insertLast((E)ghead.getCoeNum(), ghead.getBalance());
				}
				ghead = ghead.getNext();
			} else { // 같은경우
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
