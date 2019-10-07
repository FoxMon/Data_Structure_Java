package TreePractice;

import java.util.*;

public class BinaryTree<Key extends Comparable<Key>> {
	private Node root;
	
	public BinaryTree() { root = null; }
	
	public Node getRoot() { return root; }
	public void setRoot(Node root) { this.root = root; }
	
	public boolean isEmpty() { return ( root == null ); }
	
	public void preorder(Node n) {
		if(n != null) {
			System.out.print(n.getKey() + " ");
			
			preorder(n.getLeft());
			preorder(n.getRight());
		}
	}
	
	public void inorder(Node n) {
		if(n != null) {
			inorder(n.getLeft());
			
			System.out.print(n.getKey() + " ");
			
			inorder(n.getRight());
		}
	}
	
	public void postorder(Node n) {
		if(n != null) {
			postorder(n.getLeft());
			postorder(n.getRight());
			
			System.out.print(n.getKey() + " ");
		}
	}
	
	public void levelorder(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		Node temp;
		
		q.add(root);
		
		while(!q.isEmpty()) {
			temp = q.remove();
			
			System.out.print(temp.getKey() + " ");
			
			if(temp.getLeft() != null) {
				q.add(temp.getLeft());
			}
			
			if(temp.getRight() != null) {
				q.add(temp.getRight());
			}
		}
	}
	
	public int size(Node n) {
		if(n == null) {
			return 0;
		} else {
			return ( 1 + size(n.getLeft()) + size(n.getRight()));
		}
	}
	
	public int height(Node n) {
		if(n == null) {
			return 0;
		} else {
			return ( 1 + Math.max(height(n.getLeft()), height(n.getRight())) );
		}
	}
	
	public static boolean isEqual(Node n, Node m) {
		if(n == null || m == null) {
			return ( n == m );
		}
		
		if(n.getKey().compareTo(m.getKey()) != 0) {
			return false;
		}
		
		return ( isEqual(n.getLeft(), m.getLeft()) && isEqual(n.getRight(), m.getRight()) );
	}
} 