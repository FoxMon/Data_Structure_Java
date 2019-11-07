package List;

public class DNode<E> {
	private E item;
	private DNode previous;
	private DNode next;
	
	public DNode(E item, DNode previous, DNode next) {
		this.item = item;
		this.previous = previous;
		this.next = next;
	}
	
	public E getItem() { return item; }
	public DNode getPrevious() { return previous; }
	public DNode getNext() { return next; }
	public void setItem(E item) { this.item = item; }
	public void setPrevious(DNode previous) { this.previous = previous; }
	public void setNext(DNode next) { this.next = next; }
}
