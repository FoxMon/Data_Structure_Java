public class Node<E> {
	private E item;
	private Node<E> next;
	
	public Node(E item, Node<E> node) { // ������
		this.item = item; // ���ο� ������ ����
		next = node; // ���۷����� ����
	}
	
	public E getItem() {
		return item;
	}
	
	public Node<E> getNext(){
		return next;
	}
	
	public void setItem(E item) {
		this.item = item;
	}
	
	public void setNext(Node<E> next) {
		this.next = next;
	}
}
