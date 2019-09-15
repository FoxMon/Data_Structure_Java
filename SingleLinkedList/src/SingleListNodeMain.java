public class SingleListNodeMain {
	public static void main(String[] args) {
		SingleListNode<Integer> fx = new SingleListNode<Integer>();
		SingleListNode<Integer> gx = new SingleListNode<Integer>();
		SingleListNode<Integer> hx = new SingleListNode<Integer>();
		
		fx.insertFront(-9, 0); // fx�� ��� ���� ����
		fx.insertFront(-2, 2);
		fx.insertFront(7, 3);
		fx.insertFront(3, 6);
		
		System.out.print("F(x) = ");  // fx�� �� Ȯ��
		
		fx.print(); // fx�� ��� ���
		
		gx.insertFront(1, 0); // gx�� ��� ���� ����
		gx.insertFront(6, 1);
		gx.insertFront(6, 2);
		gx.insertFront(-4, 4);
		gx.insertFront(-2, 6);
		
		System.out.print("G(x) = "); // gx�� �� Ȯ��
		
		gx.print(); // gx�� ��� ���
		
		hx.addNode(fx.getNode(), gx.getNode()); // fx�� gx�� ���� ����
		
		System.out.print("H(x) = "); // hx�� �� Ȯ��
		//hx.reverse();
		hx.print(); // ������
	}
}
