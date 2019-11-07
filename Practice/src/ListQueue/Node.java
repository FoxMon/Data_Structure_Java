package ListQueue;

public class Node<E> {
	private Node<E> next;
	private E item;
	
	public Node(E item, Node<E> next) {
		this.next = next;
		this.item = item;
	}
	
	public Node<E> getNext() { return next; }
	public E getItem() { return item; }
	public void setNext(Node<E> next) { this.next = next; }
	public void setItem(E item) { this.item = item; }
}