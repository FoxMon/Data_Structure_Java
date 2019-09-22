public class Node<E> {
	private Node<E> next; // 다음 항목의 레퍼런스
	private E item; // 항목의 item
	
	public Node(E item, Node<E> next) {
		this.item = item;
		this.next = next;
	}
	
	// get과 set메소드
	
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
