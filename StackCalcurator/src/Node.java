public class Node<E> {
	private E item; // 노드안의 item
	private Node<E> next; // 다음 노드를 가리키는 next
	
	public Node(E item, Node<E> next) {
		this.item = item;
		this.next = next;
	}
	
	// set과 get메소드들
	
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
