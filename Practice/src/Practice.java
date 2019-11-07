import  java.util.Scanner;

public class Practice {
	int cnt  = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n;
		
		n = scan.nextInt();
		Practice pr = new Practice();
		
		pr.hanoi(n, '1', '2', '3');
	}
	
	public void hanoi(int n, char from, char to, char by) {
		if(n == 1 ) {
			cnt++;
			System.out.println(cnt + " " + from + "->" + by);
		} else {
			hanoi(n-1, from, by, to);
			cnt++;
			System.out.println(cnt + " " + from + "->" + by);
			hanoi(n-1, to, from, by);
		}
	}
}