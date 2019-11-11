package AVLTree;

public class Node<Key extends Comparable<Key>, Value> {
	private Key id;
	private Value name;
	private int height;
	private Node left, right;
	
	public Node(Key id, Value name, int height) {
		this.id = id;
		this.name = name;
		this.height = height;
		left = right = null;
	}
	
	public Key getKey() { return id; }
	public Value getValue() { return name; }
	public Node getLeft() { return left; }
	public Node getRight() { return right; }
	public int getHeight() { return height; }
	public void setKey(Key id) { this.id = id; }
	public void setValue(Value name) { this.name = name; }
	public void setLeft(Node left) { this.left = left; }
	public void setRight(Node right) { this.right = right; }
	public void setHeight(int height) { this.height = height; }
}