package PriorityQueue;

public class Entry<Key extends Comparable<Key>, Value> { // �켱����ť�� �����ϱ� ���� Entry
	private Key key;
	private Value value;
	
	public Entry(Key key, Value value) { // Entry�� ������
		this.key = key;
		this.value = value;
	}
	
	// get�� set �޼ҵ�
	
	public Key getKey() { return key; }
	public Value getValue() { return value; }
	public void setKey(Key key) { this.key = key; }
	public void setValue(Value value) { this.value = value; }
}