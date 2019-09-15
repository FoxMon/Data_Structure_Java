public class Node<E> {
	private E coeNum; // 계수
	private int balance; // 차수
	private Node<E> nextNum; // 다음 항의 레퍼런스
	
	public Node(E coeNum, int balance, Node<E> nextNum) { // 성성자
		this.coeNum = coeNum;
		this.balance = balance;
		this.nextNum = nextNum;
	}
	
	public void setNext(Node<E> nextNum) { // Next 설정자
		this.nextNum = nextNum;
	}
	
	public Node<E> getNext(){ // Next 접근자
		return nextNum;
	}
	
	public void setCoeNum(E coeNum) { // CoeNum 설정자
		this.coeNum = coeNum;
	}
	
	public E getCoeNum() { // CoeNum 접근자
		return coeNum;
	}
	
	public void setBalance(int balance) { // Balance 설정자
		this.balance = balance;
	}
	
	public int getBalance() { // Balance 접근자
		return balance;
	}
}
