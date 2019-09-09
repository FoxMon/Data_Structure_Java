public class SingleListMain {
	public static void main(String[] args) {
		SingleList<String> sl = new SingleList<String>();
		
		sl.insertFront("orange");
		sl.insertFront("apple");
		sl.insertAfter("cherry", sl.head.getNext());
		sl.insertFront("pear");
		
		sl.print();
		
		System.out.println(": sl의 길이  = " + sl.getSize() + "\n");
		System.out.println("체리가 " + sl.search("cherry") + "번째에 있다.");
		// System.out.println("키위가 " + sl.search("kiwi") + "번째에 있다.");
		
		// sl.deleteAfter(sl.head);
		// sl.print();
		
		// System.out.println(": sl의 길이  = " + sl.getSize() + "\n");
		
		SingleList<Integer> t = new SingleList<Integer>();
		t.insertFront(500);
		t.insertFront(200);
		t.insertAfter(400, t.head);
		t.insertFront(100);
		t.insertAfter(400, t.head.getNext());
		t.print();
			
		System.out.println(": t의 길이  = " + t.getSize() + "\n");
	}
}
