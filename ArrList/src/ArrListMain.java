
public class ArrListMain {
	public static void main(String[] args) {
		ArrList<String> arrString = new ArrList<String>(); // ArrList객체 생성
		
		arrString.insert("apple");
		arrString.print();
		arrString.insert("orange");
		arrString.print();
		arrString.insert("cherry");
		arrString.print();
		arrString.insert("pear");
		arrString.print();
		arrString.insert("grape", 1);
		arrString.print();
		arrString.insert("lemon", 4);
		arrString.print();
		arrString.insert("kiwi");
		arrString.print();
		arrString.delete(4);
		arrString.print();
		arrString.delete(0);
		arrString.print();
		arrString.delete(0);
		arrString.print();
		arrString.delete(3);
		arrString.print();
		arrString.delete(0);
		arrString.print();
		
		System.out.println("1번째 요소는 " + arrString.getIndexElement(1) + "입니다.");
	}
}
