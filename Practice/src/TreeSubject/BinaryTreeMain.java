package TreeSubject;

public class BinaryTreeMain { // BinaryTree main class
	public static void main(String[] args) {
		Node n1 = new Node('A', null, null); Node n2 = new Node('B', null, null); // 노드생성
		Node n3 = new Node('C', null, null); Node n4 = new Node('D', null, null);
		Node n5 = new Node('E', null, null); Node n6 = new Node('F', null, null);
		Node n7 = new Node('G', null, null); Node n8 = new Node('H', null, null);
		Node n9 = new Node('I', null, null); Node n10 = new Node('J', null, null);
		
		n1.setLeft(n2); n1.setRight(n3); // 노드 설정
		n2.setLeft(n4); n2.setRight(n5);
		n3.setRight(n6); n5.setLeft(n8);
		n6.setLeft(n9); n6.setRight(n10);
		n8.setLeft(n7);
		
		BinaryTree tree = new BinaryTree();
		
		tree.setRoot(n1); // 뿌리를 n1으로 설정
		
		System.out.print("트리 노드 수 = " + tree.size(tree.getRoot()) + "\n트리 높이 = " + tree.height(tree.getRoot()));
		System.out.printf("\n전위순회: ");
		tree.preorder(tree.getRoot());
		System.out.printf("\n중위순회: ");
		tree.inorder(tree.getRoot());
		System.out.printf("\n후위순회: ");
		tree.postorder(tree.getRoot());
		System.out.printf("\n레벨순회: ");
		tree.levelorder(tree.getRoot());
		System.out.println();
		
		System.out.println("단말노드의 개수는 " + tree.countLeaf(tree.getRoot()) + "개 입니다.");
	}
}