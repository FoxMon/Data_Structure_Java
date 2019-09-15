public class SingleListNodeMain {
	public static void main(String[] args) {
		SingleListNode<Integer> fx = new SingleListNode<Integer>();
		SingleListNode<Integer> gx = new SingleListNode<Integer>();
		SingleListNode<Integer> hx = new SingleListNode<Integer>();
		
		fx.insertFront(-9, 0); // fx의 요소 삽입 진행
		fx.insertFront(-2, 2);
		fx.insertFront(7, 3);
		fx.insertFront(3, 6);
		
		System.out.print("F(x) = ");  // fx의 식 확인
		
		fx.print(); // fx의 노드 출력
		
		gx.insertFront(1, 0); // gx의 요소 삽입 진행
		gx.insertFront(6, 1);
		gx.insertFront(6, 2);
		gx.insertFront(-4, 4);
		gx.insertFront(-2, 6);
		
		System.out.print("G(x) = "); // gx의 식 확인
		
		gx.print(); // gx의 노드 출력
		
		hx.addNode(fx.getNode(), gx.getNode()); // fx와 gx의 덧셈 수행
		
		System.out.print("H(x) = "); // hx의 식 확인
		//hx.reverse();
		hx.print(); // 결과출력
	}
}
