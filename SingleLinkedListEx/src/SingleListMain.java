public class SingleListMain {
	public static void main(String[] args) {
		SingleList<String> sl = new SingleList<String>();
		
		sl.insertFront("orange");
		sl.insertFront("apple");
		sl.insertAfter("cherry", sl.head.getNext());
		sl.insertFront("pear");
		
		sl.print();
		
		System.out.println(": sl�� ����  = " + sl.getSize() + "\n");
		System.out.println("ü���� " + sl.search("cherry") + "��°�� �ִ�.");
		// System.out.println("Ű���� " + sl.search("kiwi") + "��°�� �ִ�.");
		
		// sl.deleteAfter(sl.head);
		// sl.print();
		
		// System.out.println(": sl�� ����  = " + sl.getSize() + "\n");
		
		SingleList<Integer> t = new SingleList<Integer>();
		t.insertFront(500);
		t.insertFront(200);
		t.insertAfter(400, t.head);
		t.insertFront(100);
		t.insertAfter(400, t.head.getNext());
		t.print();
			
		System.out.println(": t�� ����  = " + t.getSize() + "\n");
	}
}
