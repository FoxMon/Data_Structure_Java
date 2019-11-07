package TreeSubject;

import java.util.*;

public class BinaryTree<Key extends Comparable<Key>> {
	private Node root; // Root Node
	
	public BinaryTree() { root = null; }
	
	// Getter and Setter
	public Node getRoot() { return root; }
	public void setRoot(Node root) { this.root = root; }
	
	public boolean isEmpty() { return ( root == null ); } // null이면 true
	
	public void preorder(Node myNode) { // 전위순회
		if(myNode != null) { // 나 -> 왼쪽 -> 오른쪽 순서로 방문
			System.out.print(myNode.getKey() + " "); // 나 방문
			
			preorder(myNode.getLeft()); // 왼쪽 방문
			preorder(myNode.getRight()); // 오른쪽 방문
		}
	}
	
	public void inorder(Node myNode) { // 중위순회
		if(myNode != null) { // 왼쪽 -> 나 -> 오른쪽 순서로 방문
			inorder(myNode.getLeft()); // 왼쪽 방문
			
			System.out.print(myNode.getKey() + " "); // 나 방문
			
			inorder(myNode.getRight()); // 오른쪽 방문
		}
	}
	
	public void postorder(Node myNode) { // 후위순회
		if(myNode != null) { // 왼쪽 -> 오른쪽 -> 나 순서로 방문
			postorder(myNode.getLeft()); // 왼쪽 방문
			postorder(myNode.getRight()); // 오른쪽 방문
			
			System.out.print(myNode.getKey() + " "); // 나 방문
		}
	}
	
	public void levelorder(Node root) { // 레벨순회
		Queue<Node> que = new LinkedList<Node>(); // Queue자로구조 이용
		Node temp; // 임시로 저장할 노드
		
		que.add(root); // root Node부터 시작
		
		while(!que.isEmpty()) { // que가 비어있는 상태일 때까지 반복
			temp = que.remove(); // 맨 위쪽 level 부터 삭제하기 시작
			
			System.out.print(temp.getKey() + " "); // 삭제한 노드 출력
			
			if(temp.getLeft() != null) { // 왼쪽 오른쪽 순서로 방문하면서 삭제
				que.add(temp.getLeft());
			}
			
			if(temp.getRight() != null) {
				que.add(temp.getRight());
			}
		}
	}
	
	public int size(Node myNode) { // myNode를 루트로 하는 (서브)트리에 있는 노드 수
		if(myNode == null) { // myNode가 null이면 0
			return 0;
		} else { // 아닌 경우 재귀적 방식을 이용하여 갯수 계산
			return ( 1 + size(myNode.getLeft()) + size(myNode.getRight()));
		}
	}
	
	public int height(Node myNode) { // myNode를 높이로 하는 (서브)트리의 높이
		if(myNode == null) { // null 이면 0 리턴
			return 0;
		} else { // 양 쪽의 hegiht 비교하여 더 높은 쪽에 1 더하여 height를 구함
			return ( 1 + Math.max(height(myNode.getLeft()), height(myNode.getRight())) );
		}
	}
	
	public static boolean isEqual(Node n1, Node n2) { // 동일성 검사
		if(n1 == null || n2 == null) { // 둘중 하나라도 null이면
			return ( n1 == n2 ); // 둘 다 null이면 true, 아니면 false
		}
		
		if(n1.getKey().compareTo(n2.getKey()) != 0) { // 둘 다 null이 아니면 item비교
			return false;
		}
		
		return ( isEqual(n1.getLeft(), n2.getLeft()) && isEqual(n1.getRight(), n2.getRight()) ); // item 같으면 왼쪽 오른쪽 재귀 호출
	}
	
	public int countLeaf(Node root) { // 이파리노드 카운팅		
		if(root == null) { // root에 null이면 그냥 종료시킴
			return 0;
		}
		
		// 왼쪽 -> 오른쪽 -> 나 했을 때, 왼쪽, 오른쪽이 null이면 내가 단말노드 이므로, 1을 반환
		if(root.getLeft() == null && root.getRight() == null) { // 양쪽 다 노드가 없다면 1을 반환
			return 1;
		} else { // 아니라면 재귀적으로 왼쪽 / 오른쪽 방문하면서 다시 단말노드를 찾음
			return ( countLeaf(root.getLeft()) + countLeaf(root.getRight()) );
		}
	}
}