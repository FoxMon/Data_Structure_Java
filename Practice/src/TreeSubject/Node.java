package TreeSubject;
/*
 * 
 * Data_Structure Subject
 * BinaryTree
 * Count Leaf Node
 * 
 */
public class Node<Key extends Comparable<Key>> {
	private Key item; // item저장
	private Node<Key> left; // 왼쪽 Node
	private Node<Key> right; // 오른쪽 Node
	
	public Node(Key item, Node<Key> left, Node<Key> right) { // Node Constructor
		this.item = item;
		this.left = left;
		this.right = right;
	}
	
	// Setter and Getter
	
	public Key getKey() { return item; }
	public Node<Key> getLeft() { return left; }
	public Node<Key> getRight() { return right; }
	public void setKey(Key item) { this.item = item; }
	public void setLeft(Node<Key> left) { this.left = left; }
	public void setRight(Node<Key> right) { this.right = right; }
}