package PriorityQueue;

public class Entry<Key extends Comparable<Key>, Value> { // 우선순위큐를 구현하기 위한 Entry
	private Key key;
	private Value value;
	
	public Entry(Key key, Value value) { // Entry의 생성자
		this.key = key;
		this.value = value;
	}
	
	// get과 set 메소드
	
	public Key getKey() { return key; }
	public Value getValue() { return value; }
	public void setKey(Key key) { this.key = key; }
	public void setValue(Value value) { this.value = value; }
}