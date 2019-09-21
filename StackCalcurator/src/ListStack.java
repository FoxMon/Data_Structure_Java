import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.ArrayList;

/* 
 * Data_Structure
 * Subject04
 * Stack Calcurator
 */

public class ListStack<E> {
	
	/* 
	 * Stack
	 * peek, push, pop
	 */
	
	private Node<E> top; // ������ �� ���� �׸�(���۷���)�� ����Ŵ
	private int size; // ������ �׸� ��
	
	public ListStack() {
		top = null; // �ʱⰪ null
		size = 0; // ����� �׸� 0
	}
	
	public boolean isEmpty() { // Stack�� ����ִ��� Ȯ��
		return (size == 0); // ��������� true
	}
	
	public int size() { // ����� �׸��� ���� return
		return size;
	}
	
	public E peek() { // ������ top�׸� ����
		if(isEmpty()) { // underflow �߻� �� ����ó��
			throw new EmptyStackException(); // ���α׷� ����
		}
		
		return top.getItem(); // top�� item����
	}
	
	public void push(E newItem) { // NewItem�� stack�� ����
		Node newNode = new Node(newItem, top); // NewNode ����
		
		top = newNode; // top�� ���۷����� newNode�� �ٲ�
		size++;
	}
	
	public E pop() { // top�� �׸��� ����(�׸��� ��ȯ)
		if(isEmpty()) { // stack�� �� �����̸� ����ó��
			throw new EmptyStackException();
		}
		
		E temp = top.getItem(); // �� ���� �׸��� ��ȯ�� �������� temp������ ����
		top = top.getNext(); // top�� ����Ű�� ���۷����� ������ ��尡 �ǵ�����
		
		size --; // �׸�� -1 ����
		
		return temp;
	}
	
	public static int operatorOrder(char operator) { // ������ �켱���� üũ
		switch(operator) { // �켱���� ������ �� �� ����
		case '(':
		case '[':
		case '{':
			return 0;
		case '*':
		case '/':
		case '%':
			return 2;
		case '+':
		case '-':
			return 1;
		}
		
		return -1; // ���ǿ� �����Ǵ°� ���°�� -1����
	}
	
	public static ArrayList convert(String expression) { // �������� -> �������� ǥ��
		ListStack<Character> stack = new ListStack<Character>();
		ArrayList<Character> resultExp = new ArrayList<Character>(); // ��� ǥ������ ArrayList�� ��´�.
		char top; // �� ���� item
		
		for(int i = 0; i < expression.length(); i++) { 
			switch(expression.charAt(i)) {
			case '+': case '-': case '*': case '/': case '%': // �������� �켱������ �� ũ�ų� ������ pop
				while(!stack.isEmpty() && operatorOrder(expression.charAt(i)) <= operatorOrder(stack.peek())) { 
					resultExp.add(stack.top.getItem());
					stack.pop();
				}
				stack.push(expression.charAt(i)); // �� ���� ��� push
				break;
			case '(': 
			case '[':
			case '{':
				stack.push(expression.charAt(i));
				break;
			case ')': // �����ʰ�ȣ�� ��� ���ʰ�ȣ�� ���ö����� pop
			case ']':
			case '}':
				top = stack.pop();
				
				while(top != '(' && top != '[' && top != '{') {  // �ް�ȣ�� ���ö����� pop
					resultExp.add(top);
					top = stack.pop();
				}
				
				break;
			default: // �ǿ����ڸ� �߰�
				resultExp.add(expression.charAt(i));
				break;
			}
		}
		
		while(!stack.isEmpty()) { // �����ִ°� �ִٸ� ���� ���
			resultExp.add(stack.top.getItem());
			stack.pop();
		}
		
		return resultExp;
	}
	
	public static int calcurator(ArrayList<Character> resultExp) { // �������� ���
		ListStack<Integer> value = new ListStack<Integer>(); // ������ �̿��Ͽ� ����Ұ���
		char temp; // operator�� operand�� �ӽ������� ��Ƶ� ����
		
		for(int i = 0; i < resultExp.size(); i++){
			temp = resultExp.get(i);
			
			if((temp - '0') >= 1 && (temp - '0' < 10)) { // Integer���¿� ���ٸ�
				value.push((Integer)(temp - '0')); // IntegerŸ������ ĳ���� �� push
			}
			
			switch(temp) { // ������ ��Ģ���� ����
			case '+':
			{
				int num1 = value.pop();
				int num2 = value.pop();
				value.push(num1 + num2);
				break;
			}
			case '-':
			{
				int num1 = value.pop();
				int num2 = value.pop();
				value.push(num2 - num1); // ����� push��
				break;
			}
			case '*':
			{
				int num1 = value.pop();
				int num2 = value.pop();
				value.push(num2 * num1);
				break;
			}
			case '/':
			{
				int num1 = value.pop();
				int num2 = value.pop();
				value.push(num2 / num1);
				break;
			}
			case '%':
			{
				int num1 = value.pop();
				int num2 = value.pop();
				value.push(num2 % num1);
				break;
			}
			
			}
		}
		
		int result = value.pop(); // ���
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("����: "); // �����Է�
			String expression = scan.nextLine(); // ���� ����
			
			if(expression.equals("")) {
				scan.close(); // scanner�ݾ���
				System.out.println("�����մϴ�....");
				break;
			}

			ArrayList<Character> resultExp = convert(expression); // ����ǥ������� ��ȯ�� ���� �־���
			System.out.println("�� :" + calcurator(resultExp)); // ����ǥ��� ��갪 ���
		}
		
		scan.close();
	}
}
