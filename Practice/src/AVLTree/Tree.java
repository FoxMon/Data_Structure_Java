package AVLTree;

public class Tree<Key extends Comparable<Key>, Value> {
	private Node root;
	
	public int height(Node n) {
		if(n == null) {
			return 0;
		} else {
			return (1 + Math.max(height(n.getLeft()), height(n.getRight())));
		}
	}
	
	private int bf(Node n) { return height(n.getLeft()) - height(n.getRight()); }
	
	private int tallerHeight(int x, int y) {
		if(x > y) {
			return x;
		} 

		return y;
	}
	
	private Node rotateRight(Node n) {
		Node x = n.getLeft();
		n.setLeft(x.getRight());
		x.setRight(n);
		n.setHeight(tallerHeight(height(n.getLeft()), height(n.getRight())) + 1);
		x.setHeight(tallerHeight(height(x.getLeft()), height(x.getRight())) + 1);
		
		return x;
	}
	
	private Node rotateLeft(Node n) {
		Node x = n.getRight();
		n.setRight(x.getLeft());
		x.setLeft(n);
		n.setHeight(tallerHeight(height(n.getLeft()), height(n.getRight())) + 1);
		x.setHeight(tallerHeight(height(x.getLeft()), height(x.getRight())) + 1);
		
		return x;
	}
	
	private Node balance(Node n) {
		if(bf(n) > 1) {
			if(bf(n.getLeft()) < 0) {
				n.setLeft(rotateLeft(n.getLeft()));
			}
			
			n = rotateRight(n);
			
		} else if(bf(n) < -1) {
			if(bf(n.getRight()) > 0) {
					n.setRight(rotateRight(n.getRight()));
			}
			
			n = rotateLeft(n);
		}
		
		return n;
	}
	
	public void put(Key k, Value v) { root = put(root, k, v); }
	public Node put(Node n, Key k, Value v) {
		if(n == null) {
			return new Node(k, v, 1);
		}
		
		int t = k.compareTo((Key)n.getKey());
		
		if(t > 0) {
			n.setRight(put(n.getRight(), k, v));
		} else if(t < 0) {
			n.setLeft(put(n.getLeft(), k, v));
		} else {
			n.setValue(v);
			
			return n;
		}
		
		n.setHeight(tallerHeight(height(n.getLeft()), height(n.getRight())) + 1);
		
		return balance(n); 	
	}
	
	public static void main(String[] args) {
		Tree<Integer, String> tree = new Tree<Integer, String>();
	}
}