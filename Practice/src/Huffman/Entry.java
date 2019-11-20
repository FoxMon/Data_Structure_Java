package Huffman;

public class Entry {
	private int frequency;
	private String word;
	private Entry left;
	private Entry right;
	private String code;
	
	public Entry(int frequency, String word, Entry left, Entry right, String code) {
		this.frequency = frequency;
		this.word = word;
		this.left = left;
		this.right = right;
		this.code = code;
	}
	
	public int getKey() { return frequency; }
	public String getValue() { return word; }
	public String getCode() { return code; }
	public Entry getLeft() { return left; }
	public Entry getRight() { return right; }
	public void setCode(String code) { this.code = code; }
}