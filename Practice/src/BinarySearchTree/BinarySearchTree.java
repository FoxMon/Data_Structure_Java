package BinarySearchTree;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
	public Node root;
	
	public BinarySearchTree(Key id, Value name) {
		root = new Node(id,  name);
	}
	
	public Node getRoot() { return root; }
	
	public Value get(Key target) { // Search
		return get(root, target);
	}
	
	public Value get(Node n, Key target) {
		if(n == null) {
			return null;
		}
		
		int temp = n.getKey().compareTo(target);
		
		if(temp > 0) {
			return get(n.getLeft(), target);
		} else if(temp < 0) {
			return get(n.getRight(), target);
		} else {
			return (Value)n.getValue();
		}
	}
	
	public void put(Key k, Value v) { // Insert
		root = put(root, k, v);
	}
	
	public Node put(Node n, Key k, Value v) {
		if(n == null) {
			return new Node(k, v);
		}
		
		int temp = n.getKey().compareTo(k);
		
		if(temp > 0) {
			n.setLeft(put(n.getLeft(), k, v));
		} else if(temp < 0) {
			n.setRight(put(n.getRight(), k, v));
		} else {
			n.setValue(v);
		}
		
		return n;
	}
	
	public Key min() { // Search minimum node
		if(root == null) {
			return null;
		}
		
		return (Key)min(root);
	}
	
	public Node min(Node n) {
		if(n.getLeft() == null) {
			return n;
		}
		
		return min(n.getLeft());
	}
	
	public void deleteMin() { // Delete minimum Node
		if(root == null) {
			System.out.println("Empty Tree!!!...");
		}
		
		root = deleteMin(root);
	}
	
	public Node deleteMin(Node n) { 
		if(n.getLeft() == null) {
			return n.getRight();
		}
		
		n.setLeft(deleteMin(n.getLeft()));
		
		return n;
	}
	
	public void delete(Key k) { // Delete node
		root = delete(root, k);
	}
	
	public Node delete(Node n, Key k) {
		if(n == null) {
			return null;
		}
		
		int temp = n.getKey().compareTo(k);
		
		if(temp > 0) { // Move to left subtree
			n.setLeft(delete(n.getLeft(), k));
		} else if(temp < 0) { // Move to right subtree
			n.setRight(delete(n.getRight(), k));
		} else { // Target
			if(n.getRight() == null) { // Case 0, 1
				return n.getLeft();
			}
			
			if(n.getLeft() == null) { // Case 1
				return n.getRight();
			}
			
			Node target = n; // Case 2
			n= min(target.getRight());
			n.setRight(deleteMin(target.getRight()));
			n.setLeft(target.getLeft());
		}
		
		return n;	
	}
}