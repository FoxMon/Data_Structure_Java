public class Node<E> {
	private E item;
	private Node<E> next;
	
	public Node(E newItem, Node<E> node) { // 생성자
		item = newItem; // 새로운 아이템 저장
		next = node; // 레퍼런스를 저장
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
