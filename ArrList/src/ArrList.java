import java.util.NoSuchElementException;

public class ArrList <E> {
	private E[] elements; // 리스트의 항목들을 저장할 배열
	private int size; // 리스트의 항목 수
	private int capacity; // 저장크기
	
	public ArrList() { // ArrList의 생성자
		elements = (E[]) new Object[1]; // 최초 1개의 원소를 가진 배열 생성
		size = 0; // 첫 요소 저장된 개수 = 0
		capacity = 1; // 처음 용량은 1
	}
	
	public E peek(int idx) { // k번째 항모을 리턴, 단순히 읽기만 함
		if(size == 0 || size <= idx) { // idx가 size보다 크거나 같으면
			throw new NoSuchElementException(); // underflow의 경우 프로그램 멈춤
		}
		
		return elements[idx];
	}
	
	public void resize(int newSize) { // 배열의 size를 확대 또는 축소
		Object[] tempArr = new Object[newSize]; // newSize크기의 새로운 임시배열 tempArr
		capacity = newSize; // 저장크기도 같이 갱신한다 size는 저장된 요소의 갯수만 알 수 있기 때문
		
		for(int i = 0; i < size; i++) {
			tempArr[i] = elements[i]; // elements배열을 tempArr에 그대로 복사
		}
		
		elements = (E[]) tempArr; // 크기를 늘리고, 요소를 복사한tempArr을 배열elements로 대입
	}
	
	public void insertLast(E newData) { // 마지막 index에 새로운 데이터 삽입
		if(size == elements.length) { // 배열의 크기가 elements배열의 크기와 같으면
			resize(2*elements.length); // 크기를 2배 더 늘린다
		}
		
		elements[size++] = newData; // 맨 마지막 인덱스에 넣고 size증가
	}
	
	public void insert(E newData) { // index가 주어지지 않은경우, 자동으로 뒷요소에 삽입
		if(size == elements.length) { // 사이즈 같은경우 2배로 늘림
			resize(2*elements.length);
		}

		elements[size++] = newData;
	}
	
	public void insert(E newData, int idx) { // index가 주어진 경우, insert메소드 오버로딩
		if(size == elements.length) { // 사이즈 검사
			resize(2*elements.length);
		}
		
		for(int i = size-1; i >= idx; i--) { // 뒷요소부터 복사를 할것임 그래야 데이터 손실이 없음
			elements[i+1] = elements[i]; // 복사를 해서 자리를 비워둠
		}
		
		elements[idx] = newData; // 비워둔 자리에 새로운 데이터 넣고
		size++; // 요소의 개수 증가
	}
	
	public E delete(int idx) { // 요소 삭제
		E deleteItem = elements[idx]; // 삭제항목 저장
		
		if(size == 0 || size <= idx) { // underflow의 경우 프로그램 멈춤
			throw new NoSuchElementException();
		}
		
		for(int i = idx; i < size; i++) { // 한칸씩 땡겨서 그 데이터를 없앨거임
			elements[i] = elements[i+1]; // idx기준 뒤의 데이터를 앞으로 복사
		}
		
		size--; // 요소의 개수 감소시킴
		
		if(0 < size && size == elements.length / 4) { // size가 0보다 크고, 1/4만 차지한다면
			resize(elements.length/2); // 배열의 크기를 1/2로 축소시킴
		}
		
		return deleteItem; // 삭제요소 리턴
	}
	
	public E getIndexElement(int idx) { // 지정된 인덱스의 요소를 가져옴
		return elements[idx];
	}
	
	public void print() { // 현재 배열의 상황 출력
		for(int i = 0; i < capacity; i++) { // 배열의 크기만큼 출력
			if(elements[i] != null) { // 요소가 비어있지 않다면
				System.out.print(elements[i] + "\t"); // 요소들을 출력하고
			} else { // 그렇지 않다면
				System.out.print("null" + "\t"); // null을 출력
			}
		}
		
		System.out.println();
	}
}
