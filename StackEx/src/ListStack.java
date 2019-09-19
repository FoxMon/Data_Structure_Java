import java.util.EmptyStackException;

public class ListStack<E> {
	private Node<E> top;
	private int size;
	
	public ListStack() {
		top = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public E peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		return top.getItem();
	}
	
	public void push(E newItem) {
		Node newNode = new Node(newItem, top);
		top = newNode;
		size++;
	}
	
	public E pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		E temp = top.getItem();
		top = top.getNext();
		size--;
		
		return temp;
	}
	
	public static void main(String[] args) {
		ListStack<String> stack = new ListStack<String>();
		
		stack.push("apple");
		System.out.print(stack.peek() + " ");
		stack.push("orange");
		System.out.print(stack.peek() + " ");
		stack.push("cherry");
		System.out.print(stack.peek() + " ");
		stack.push("pear");
		System.out.print(stack.peek() + " ");
		System.out.println();
		System.out.println(stack.pop());
		System.out.println(stack.peek() + " ");
	}
}
