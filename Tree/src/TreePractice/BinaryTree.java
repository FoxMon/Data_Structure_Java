package TreePractice;

import java.util.*;

public class BinaryTree<Key extends Comparable<Key>> { // Constructor
	private Node root;
	
	public BinaryTree() { root = null; }
	
	public Node getRoot() { return root; }
	public void setRoot(Node root) { this.root = root; }
	
	public boolean isEmpty() { return (root == null); }
	
	public void preorder(Node n) { // 전위순회 ( 나 -> 왼쪽 -> 오른쪽 )
		if(n != null) {
			System.out.print(n.getKey() + " "); // 나
			
			preorder(n.getLeft()); // 왼쪽방문
			preorder(n.getRight()); // 오른쪽방문
		}
	}
	
	public void inorder(Node n) { // 중위순회 ( 왼쪽 -> 나 -> 오른쪽 )
		if(n != null) {
			inorder(n.getLeft()); // 왼쪽방문
			
			System.out.print(n.getKey() + " "); // 나
			
			inorder(n.getRight()); // 오른쪽방문
		}
	}
	
	public void postorder(Node n) { // 후위순회 ( 왼쪽 -> 오른쪽 -> 나 )
		if(n != null) {
			postorder(n.getLeft()); // 왼쪽방문
			postorder(n.getRight()); // 오른쪽방문
			
			System.out.print(n.getKey() + " "); // 나
		}
	}
	
	public void levelorder(Node root) { // 레벨순회 ( 위에서부터 방문 )
		Queue<Node> q = new LinkedList<Node>(); // 큐 자료구조 이용
		Node temp;
		
		q.add(root); // 루트노드 큐에 삽입
		
		while(!q.isEmpty()) {
			temp = q.remove(); // 가장 앞 노드 뺌
			
			System.out.print(temp.getKey() + " "); // 제거된 거 출력 ( 나 )
			
			if(temp.getLeft() != null) {
				q.add(temp.getLeft());
			}
			
			if(temp.getRight() != null) {
				q.add(temp.getRight());
			}
		}
	}
	
	public int size(Node n) { // n을 루트로 하는 (서브)트리에 있는 노드 수
		if(n == null) {
			return 0; // null이면 0
		} else {
			return (1 + size(n.getLeft()) + size(n.getRight()));
		}
	}
	
	public int height(Node n) { // n을 루트로하는 (서브)트리의 높이
		if(n == null) {
			return 0; // null이면 0
		} else {
			return (1 + Math.max(height(n.getLeft()), height(n.getRight())));
		}
	}
	
	public static boolean isEqual(Node n, Node m) { // 두 트리의 동일성 검사
		if(n == null || m == null) { // 둘 중 하나라도 null
			return ( n == m ); // 둘다 null true, 아니면 false
		}
		
		if(n.getKey().compareTo(m.getKey()) != 0) { // 둘 다 null이 아니면 item 비교
			return false;
		}
		
		return( isEqual(n.getLeft(), m.getLeft()) && isEqual(n.getRight(), m.getRight()) ); // item같으면 왼쪽 / 오른쪽 자식으로 재귀호출
	}
}
