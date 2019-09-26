/**
 * 
 * Single Linked List2
 * Class Node
 * 
 */


public class Node<E> {
	private E item;
	private Node<E> next;
	private int aux;
	
	public Node(E item, Node<E> next, int aux) {
		this.item = item;
		this.next = next;
		this.aux = aux;
	}
	
	public E getItem() {
		return item;
	}
	
	public Node<E> getNext(){
		return next;
	}
	
	public int getAux() {
		return aux;
	}
	
	public void setItem(E item) {
		this.item = item;
	}
	
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	public void setAux(int aux) {
		this.aux = aux;
	}
}
