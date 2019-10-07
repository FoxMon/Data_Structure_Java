package BSTree;

public class BsTree<Key extends Comparable<Key>, Value> {
	public Node root;
	
	public Node getNode() { return root; }
	
	public BsTree(Key id, Value name) { root = new Node(id, name); }
	
	public Value get(Key k) { return get(root, k); }
	public Value get(Node n, Key k) {
		if(n == null) {
			return null;
		}
		
		int temp = n.getKey().compareTo(k);
		
		if(temp > 0) {
			return get(n.getLeft(), k);
		} else if(temp < 0) {
			return get(n.getRight(), k);
		} else {
			return (Value)n.getValue();
		}
	}
	
	public void put(Key k, Value v) { root = put(root, k, v); }
	public Node put(Node n, Key k, Value v) {
		if(n == null) { return new Node(k, v); }
		
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
	
	public Key min() {
		if(root == null) {
			return null;
		}
		
		return (Key)min(root).getKey();
	}
	
	private Node min(Node n) {
		if(n.getLeft() == null) {
			return n;
		}
		
		return min(n.getLeft());
	}
	
	public void deleteMin() {
		if(root == null) {
			System.out.println("Empty 트리");
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
	
	public void delete(Key k) {
		root = delete(root, k);
	}
	
	public Node delete(Node n, Key k) {
		if(n == null) {
			return null;
		}
		
		int temp = n.getKey().compareTo(k);
		
		if(temp > 0) {
			n.setLeft(delete(n.getLeft(), k));
		} else if(temp < 0) {
			n.setRight(delete(n.getRight(), k));
		} else {
			if(n.getRight() == null) {
				return n.getLeft();
			}
			
			if((n.getLeft() == null)) {
				return n.getRight();
			}
			
			Node target = n;
			n = min(target.getRight());
			
			n.setRight(deleteMin(target.getRight()));
			n.setLeft(target.getLeft());
		}
		
		return n;
	}
	
	public static void main(String[] args) {
		BsTree<Integer, String> tree = new BsTree<Integer, String>(10, "Root");
		// 이 후 연산 실행
	}
}