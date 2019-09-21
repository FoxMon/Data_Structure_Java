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
	
	private Node<E> top; // 스택의 맨 위의 항목(레퍼런스)를 가리킴
	private int size; // 스택의 항목 수
	
	public ListStack() {
		top = null; // 초기값 null
		size = 0; // 저장된 항목 0
	}
	
	public boolean isEmpty() { // Stack이 비어있는지 확인
		return (size == 0); // 비어있으면 true
	}
	
	public int size() { // 저장된 항목의 개수 return
		return size;
	}
	
	public E peek() { // 스택의 top항목 리턴
		if(isEmpty()) { // underflow 발생 시 예외처리
			throw new EmptyStackException(); // 프로그램 정지
		}
		
		return top.getItem(); // top의 item리턴
	}
	
	public void push(E newItem) { // NewItem을 stack에 넣음
		Node newNode = new Node(newItem, top); // NewNode 생성
		
		top = newNode; // top의 레퍼런스를 newNode로 바꿈
		size++;
	}
	
	public E pop() { // top의 항목을 제거(그리고 반환)
		if(isEmpty()) { // stack이 빈 공간이면 예외처리
			throw new EmptyStackException();
		}
		
		E temp = top.getItem(); // 맨 위의 항목을 반환할 목적으로 temp변수에 저장
		top = top.getNext(); // top이 가리키는 레퍼런스가 이전의 노드가 되도록함
		
		size --; // 항목수 -1 감소
		
		return temp;
	}
	
	public static int operatorOrder(char operator) { // 연산자 우선순위 체크
		switch(operator) { // 우선순위 높은걸 값 더 높게
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
		
		return -1; // 조건에 충족되는게 없는경우 -1리턴
	}
	
	public static ArrayList convert(String expression) { // 중위연산 -> 후위연산 표현
		ListStack<Character> stack = new ListStack<Character>();
		ArrayList<Character> resultExp = new ArrayList<Character>(); // 결과 표현식을 ArrayList에 담는다.
		char top; // 맨 위의 item
		
		for(int i = 0; i < expression.length(); i++) { 
			switch(expression.charAt(i)) {
			case '+': case '-': case '*': case '/': case '%': // 연산자의 우선순위가 더 크거나 같으면 pop
				while(!stack.isEmpty() && operatorOrder(expression.charAt(i)) <= operatorOrder(stack.peek())) { 
					resultExp.add(stack.top.getItem());
					stack.pop();
				}
				stack.push(expression.charAt(i)); // 그 외의 경우 push
				break;
			case '(': 
			case '[':
			case '{':
				stack.push(expression.charAt(i));
				break;
			case ')': // 오른쪽괄호의 경우 왼쪽괄호가 나올때까지 pop
			case ']':
			case '}':
				top = stack.pop();
				
				while(top != '(' && top != '[' && top != '{') {  // 왼괄호가 나올때까지 pop
					resultExp.add(top);
					top = stack.pop();
				}
				
				break;
			default: // 피연산자를 추가
				resultExp.add(expression.charAt(i));
				break;
			}
		}
		
		while(!stack.isEmpty()) { // 남아있는게 있다면 전부 출력
			resultExp.add(stack.top.getItem());
			stack.pop();
		}
		
		return resultExp;
	}
	
	public static int calcurator(ArrayList<Character> resultExp) { // 후위연산 계산
		ListStack<Integer> value = new ListStack<Integer>(); // 스택을 이용하여 계산할거임
		char temp; // operator와 operand를 임시적으로 담아둘 변수
		
		for(int i = 0; i < resultExp.size(); i++){
			temp = resultExp.get(i);
			
			if((temp - '0') >= 1 && (temp - '0' < 10)) { // Integer형태와 같다면
				value.push((Integer)(temp - '0')); // Integer타입으로 캐스팅 후 push
			}
			
			switch(temp) { // 적절한 사칙연산 수행
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
				value.push(num2 - num1); // 결과를 push함
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
		
		int result = value.pop(); // 결과
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("수식: "); // 수식입력
			String expression = scan.nextLine(); // 한줄 읽음
			
			if(expression.equals("")) {
				scan.close(); // scanner닫아줌
				System.out.println("종료합니다....");
				break;
			}

			ArrayList<Character> resultExp = convert(expression); // 후위표기법으로 전환된 것을 넣어줌
			System.out.println("값 :" + calcurator(resultExp)); // 후위표기법 계산값 출력
		}
		
		scan.close();
	}
}
