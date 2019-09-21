public class Node<E> {
	private E item; // ������ item
	private Node<E> next; // ���� ��带 ����Ű�� next
	
	public Node(E item, Node<E> next) {
		this.item = item;
		this.next = next;
	}
	
	// set�� get�޼ҵ��
	
	public void setItem(E item) {
		this.item = item;
	}
	
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	public E getItem() {
		return item;
	}
	
	public Node<E> getNext(){
		return next;
	}
}
