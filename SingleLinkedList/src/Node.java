public class Node<E> {
	private E coeNum; // ���
	private int balance; // ����
	private Node<E> nextNum; // ���� ���� ���۷���
	
	public Node(E coeNum, int balance, Node<E> nextNum) { // ������
		this.coeNum = coeNum;
		this.balance = balance;
		this.nextNum = nextNum;
	}
	
	public void setNext(Node<E> nextNum) { // Next ������
		this.nextNum = nextNum;
	}
	
	public Node<E> getNext(){ // Next ������
		return nextNum;
	}
	
	public void setCoeNum(E coeNum) { // CoeNum ������
		this.coeNum = coeNum;
	}
	
	public E getCoeNum() { // CoeNum ������
		return coeNum;
	}
	
	public void setBalance(int balance) { // Balance ������
		this.balance = balance;
	}
	
	public int getBalance() { // Balance ������
		return balance;
	}
}
