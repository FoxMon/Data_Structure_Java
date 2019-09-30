package TreePractice;

import java.util.*;

public class BinaryTree<Key extends Comparable<Key>> { // Constructor
	private Node root;
	
	public BinaryTree() { root = null; }
	
	public Node getRoot() { return root; }
	public void setRoot(Node root) { this.root = root; }
	
	public boolean isEmpty() { return (root == null); }
	
	public void preorder(Node n) { // ������ȸ ( �� -> ���� -> ������ )
		if(n != null) {
			System.out.print(n.getKey() + " "); // ��
			
			preorder(n.getLeft()); // ���ʹ湮
			preorder(n.getRight()); // �����ʹ湮
		}
	}
	
	public void inorder(Node n) { // ������ȸ ( ���� -> �� -> ������ )
		if(n != null) {
			inorder(n.getLeft()); // ���ʹ湮
			
			System.out.print(n.getKey() + " "); // ��
			
			inorder(n.getRight()); // �����ʹ湮
		}
	}
	
	public void postorder(Node n) { // ������ȸ ( ���� -> ������ -> �� )
		if(n != null) {
			postorder(n.getLeft()); // ���ʹ湮
			postorder(n.getRight()); // �����ʹ湮
			
			System.out.print(n.getKey() + " "); // ��
		}
	}
	
	public void levelorder(Node root) { // ������ȸ ( ���������� �湮 )
		Queue<Node> q = new LinkedList<Node>(); // ť �ڷᱸ�� �̿�
		Node temp;
		
		q.add(root); // ��Ʈ��� ť�� ����
		
		while(!q.isEmpty()) {
			temp = q.remove(); // ���� �� ��� ��
			
			System.out.print(temp.getKey() + " "); // ���ŵ� �� ��� ( �� )
			
			if(temp.getLeft() != null) {
				q.add(temp.getLeft());
			}
			
			if(temp.getRight() != null) {
				q.add(temp.getRight());
			}
		}
	}
	
	public int size(Node n) { // n�� ��Ʈ�� �ϴ� (����)Ʈ���� �ִ� ��� ��
		if(n == null) {
			return 0; // null�̸� 0
		} else {
			return (1 + size(n.getLeft()) + size(n.getRight()));
		}
	}
	
	public int height(Node n) { // n�� ��Ʈ���ϴ� (����)Ʈ���� ����
		if(n == null) {
			return 0; // null�̸� 0
		} else {
			return (1 + Math.max(height(n.getLeft()), height(n.getRight())));
		}
	}
	
	public static boolean isEqual(Node n, Node m) { // �� Ʈ���� ���ϼ� �˻�
		if(n == null || m == null) { // �� �� �ϳ��� null
			return ( n == m ); // �Ѵ� null true, �ƴϸ� false
		}
		
		if(n.getKey().compareTo(m.getKey()) != 0) { // �� �� null�� �ƴϸ� item ��
			return false;
		}
		
		return( isEqual(n.getLeft(), m.getLeft()) && isEqual(n.getRight(), m.getRight()) ); // item������ ���� / ������ �ڽ����� ���ȣ��
	}
}
