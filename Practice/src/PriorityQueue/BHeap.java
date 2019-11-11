package PriorityQueue;

public class BHeap<Key extends Comparable<Key>, Value> { // ������ Ŭ����
	private Entry[] arr; // arr[0]�� ������� ����
	private int size; // ���� ũ��, �� ���� �ִ� �׸��� ��
	
	public BHeap(Entry[] arr, int initialSize) {
		this.arr = arr;
		this.size = initialSize;
	}
	
	public int size() { return size; } // ���� ũ�� ����
	private boolean greater(int i, int j) { return arr[j].getKey().compareTo(arr[i].getKey()) < 0; } // Ű�� �� -> j�� ��������
	
	private void swap(int i, int j) { // arr[i]�� arr[j]�� ��ȯ�Ѵ� 
		Entry temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private void downheap(int i) { // i�� ���� ����� �ε���
		while(2 * i <= size) { // i�� ���� �ڽĳ�尡 ���� ������
			int k = 2*i; // k�� ���� �ڽĳ���� �ε���
			
			if(k < size && greater(k, k+1)) { // k�� ������ �ε����� ��
				k++; // ���� �ε����� �ǵ��� ���� ���
			}
			
			if(!greater(i, k)) { // ���� ��尡 �ڽ� ���ڿ� ���ų� ������ ������ �ߴ�
				break; // ���� �ߴ�
			}
			
			swap(i, k); // ���� ��尡 �ڽ� ���ں��� ũ�� ���� ���� �ڽ� ���ڿ� ��ȯ
			i = k; // �ڽ� ���ڰ� ���� ��尡 �Ǿ� �ٽ� �ݺ�
		}
	}
	
	private void upheap(int j) { // j�� ���� ����� �ε���
		while(j > 1 && greater(j/2, j)) { // ���� ��尡 ��Ʈ�� �ƴϰ� ���ÿ� �θ� ũ��
			swap(j/2, j); // �θ�� ���� ��� ��ȯ
			j = j / 2; // �θ� ���� ��尡 �Ǿ� �ٽ� �ݺ��ϱ� ����
		}
	}
	
	public void createHeap() { // �ʱ��� �� �����
		for(int i = size / 2; i > 0; i--) { // Bottom - Up ��� ( ����� )
			downheap(i);
		}
	}
	
	public void insert(Key newKey, Value newValue) { // ���ο� �׸� ����
		Entry temp = new Entry(newKey, newValue); // Entry ����
		arr[++size] = temp; // ���ο� Ű( �׸� )�� �迭 ������ �׸� ������ ����
		upheap(size); // ���� �ö󰡸� �� �Ӽ��� ȸ����Ŵ
	}
	
	public Entry deleteMin() { // �ּڰ� ����
		Entry min = arr[1]; // arr[1]�� �ּڰ��� min���� ����
		
		swap(1, size--); // ���� ������ �׸�� ��ȯ�ϰ� ���� ũ�⸦ 1 ����
		arr[size + 1] = null; // ������ �׸��� null�� ó�� ( Garbage Collection )
		downheap(1); // �� �Ӽ��� ȸ����Ű�� ����
		
		return min; // ������ �ּڰ��� ����
	}
}
