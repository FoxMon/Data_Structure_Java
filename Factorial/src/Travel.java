
public class Travel {
	private Node start;
	
	public class Node {
		private char name; // 级捞抚
		private Node left, right; // 级 荤捞狼 促府 楷搬
		
		public Node(char newIsland, Node lt, Node rt) {
			this.name = newIsland;
			this.left = lt;
			this.right = rt;
		}
	}
		
		public Node map() { // 瘤档 父甸扁
			Node n1 = new Node('H', null, null); 
			Node n2 = new Node('F', null, null); 
			Node n3 = new Node('S', null, null);
			Node n4 = new Node('U', null, null); 
			Node n5 = new Node('E', null, null); 
			Node n6 = new Node('Z', null, null);  
			Node n7 = new Node('K', null, null); 
			Node n8 = new Node('N', null, null); 
			Node n9 = new Node('A', null, null); 
			Node n10 = new Node('Y', null, null);
			Node n11 = new Node('T', null, null);
			
			n1.left = n2; // n1狼 哭率级 n2
			n1.right = n3; // n1狼 坷弗率级 n3
			n2.left = n4; // n2狼 哭率级 n4
			n2.right = n5; // n2狼 坷弗率级 n5
			n3.left = n6; // n3狼 哭率级 n6
			n3.right = n7; // n3狼 坷弗率级 n7
			n4.left = n8; // n4狼 哭率级 n8
			n5.left = n9; // n5狼 哭率级 n9
			n7.right = n10; // n7狼 哭率级 n10
			n9.right = n11; // n9狼 坷弗率级 n11
			
			return n1;
		}
		
		public void A_Course(Node n) { // A-Course
			if(n != null) {
				System.out.print(n.name + "-> ");
				
				A_Course(n.left); // Left
				A_Course(n.right); // Right
			}
		}
		
		public void B_Course(Node n) { // B-Course
			if(n != null) {
				B_Course(n.left); // Left
				
				System.out.print(n.name + "-> ");
				
				B_Course(n.right); // Right
			}
		}
		
		public void C_Course(Node n) { // C-Course
			if(n != null) {
				C_Course(n.left); // Left
				C_Course(n.right); // Right
				
				System.out.print(n.name + "-> ");
			}
		}
		
		public static void main(String args[]) {
			Travel t = new Travel(); // 咯青按眉 t
		
			t.start = t.map();
			
			System.out.println("A-内胶: ");
			t.A_Course(t.start);
			
			System.out.println("\nB-内胶: ");
			t.B_Course(t.start);
			
			System.out.println("\nC-内胶: ");
			t.C_Course(t.start);
		}
}
