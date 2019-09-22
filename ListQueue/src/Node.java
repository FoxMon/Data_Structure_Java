public class Node<E> {
	private Node<E> next; // ���� �׸��� ���۷���
	private E item; // �׸��� item
	
	public Node(E item, Node<E> next) {
		this.item = item;
		this.next = next;
	}
	
	// get�� set�޼ҵ�
	
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	public void setItem(E item) {
		this.item = item;
	}
	
	public Node<E> getNext(){
		return next;
	}
	
	public E getItem() {
		return item;
	}
}
