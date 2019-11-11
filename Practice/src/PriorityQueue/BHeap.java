package PriorityQueue;

public class BHeap<Key extends Comparable<Key>, Value> { // 이진힙 클래스
	private Entry[] arr; // arr[0]은 사용하지 않음
	private int size; // 힙의 크기, 즉 힙에 있는 항목의 수
	
	public BHeap(Entry[] arr, int initialSize) {
		this.arr = arr;
		this.size = initialSize;
	}
	
	public int size() { return size; } // 힙의 크기 리턴
	private boolean greater(int i, int j) { return arr[j].getKey().compareTo(arr[i].getKey()) < 0; } // 키를 비교 -> j를 기준으로
	
	private void swap(int i, int j) { // arr[i]와 arr[j]를 교환한다 
		Entry temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private void downheap(int i) { // i는 현재 노드의 인덱스
		while(2 * i <= size) { // i의 왼쪽 자식노드가 힙에 있으면
			int k = 2*i; // k는 왼쪽 자식노드의 인덱스
			
			if(k < size && greater(k, k+1)) { // k가 승자의 인덱스가 됨
				k++; // 승자 인덱스가 되도록 값을 상승
			}
			
			if(!greater(i, k)) { // 현재 노드가 자식 승자와 같거나 작으면 루프를 중단
				break; // 루프 중단
			}
			
			swap(i, k); // 현재 노드가 자식 승자보다 크면 현재 노드와 자식 승자와 교환
			i = k; // 자식 승자가 현재 노드가 되어 다시 반복
		}
	}
	
	private void upheap(int j) { // j는 현재 노드의 인덱스
		while(j > 1 && greater(j/2, j)) { // 현재 노드가 루트가 아니고 동시에 부모가 크면
			swap(j/2, j); // 부모와 현재 노드 교환
			j = j / 2; // 부모가 현재 노드가 되어 다시 반복하기 위해
		}
	}
	
	public void createHeap() { // 초기의 힙 만들기
		for(int i = size / 2; i > 0; i--) { // Bottom - Up 방식 ( 상향식 )
			downheap(i);
		}
	}
	
	public void insert(Key newKey, Value newValue) { // 새로운 항목 삽입
		Entry temp = new Entry(newKey, newValue); // Entry 생성
		arr[++size] = temp; // 새로운 키( 항목 )를 배열 마지막 항목 다음에 저장
		upheap(size); // 위로 올라가며 힙 속성을 회복시킴
	}
	
	public Entry deleteMin() { // 최솟값 삭제
		Entry min = arr[1]; // arr[1]의 최솟값을 min으로 저장
		
		swap(1, size--); // 힙의 마지막 항목과 교환하고 힙의 크기를 1 감소
		arr[size + 1] = null; // 마지막 항목을 null로 처리 ( Garbage Collection )
		downheap(1); // 힙 속성을 회복시키기 위해
		
		return min; // 삭제한 최솟값을 리턴
	}
}
