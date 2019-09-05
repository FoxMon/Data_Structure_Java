import java.util.NoSuchElementException;

public class ArrList <E> {
	private E[] elements; // ����Ʈ�� �׸���� ������ �迭
	private int size; // ����Ʈ�� �׸� ��
	private int capacity; // ����ũ��
	
	public ArrList() { // ArrList�� ������
		elements = (E[]) new Object[1]; // ���� 1���� ���Ҹ� ���� �迭 ����
		size = 0; // ù ��� ����� ���� = 0
		capacity = 1; // ó�� �뷮�� 1
	}
	
	public E peek(int idx) { // k��° �׸��� ����, �ܼ��� �б⸸ ��
		if(size == 0 || size <= idx) { // idx�� size���� ũ�ų� ������
			throw new NoSuchElementException(); // underflow�� ��� ���α׷� ����
		}
		
		return elements[idx];
	}
	
	public void resize(int newSize) { // �迭�� size�� Ȯ�� �Ǵ� ���
		Object[] tempArr = new Object[newSize]; // newSizeũ���� ���ο� �ӽù迭 tempArr
		capacity = newSize; // ����ũ�⵵ ���� �����Ѵ� size�� ����� ����� ������ �� �� �ֱ� ����
		
		for(int i = 0; i < size; i++) {
			tempArr[i] = elements[i]; // elements�迭�� tempArr�� �״�� ����
		}
		
		elements = (E[]) tempArr; // ũ�⸦ �ø���, ��Ҹ� ������tempArr�� �迭elements�� ����
	}
	
	public void insertLast(E newData) { // ������ index�� ���ο� ������ ����
		if(size == elements.length) { // �迭�� ũ�Ⱑ elements�迭�� ũ��� ������
			resize(2*elements.length); // ũ�⸦ 2�� �� �ø���
		}
		
		elements[size++] = newData; // �� ������ �ε����� �ְ� size����
	}
	
	public void insert(E newData) { // index�� �־����� �������, �ڵ����� �޿�ҿ� ����
		if(size == elements.length) { // ������ ������� 2��� �ø�
			resize(2*elements.length);
		}

		elements[size++] = newData;
	}
	
	public void insert(E newData, int idx) { // index�� �־��� ���, insert�޼ҵ� �����ε�
		if(size == elements.length) { // ������ �˻�
			resize(2*elements.length);
		}
		
		for(int i = size-1; i >= idx; i--) { // �޿�Һ��� ���縦 �Ұ��� �׷��� ������ �ս��� ����
			elements[i+1] = elements[i]; // ���縦 �ؼ� �ڸ��� �����
		}
		
		elements[idx] = newData; // ����� �ڸ��� ���ο� ������ �ְ�
		size++; // ����� ���� ����
	}
	
	public E delete(int idx) { // ��� ����
		E deleteItem = elements[idx]; // �����׸� ����
		
		if(size == 0 || size <= idx) { // underflow�� ��� ���α׷� ����
			throw new NoSuchElementException();
		}
		
		for(int i = idx; i < size; i++) { // ��ĭ�� ���ܼ� �� �����͸� ���ٰ���
			elements[i] = elements[i+1]; // idx���� ���� �����͸� ������ ����
		}
		
		size--; // ����� ���� ���ҽ�Ŵ
		
		if(0 < size && size == elements.length / 4) { // size�� 0���� ũ��, 1/4�� �����Ѵٸ�
			resize(elements.length/2); // �迭�� ũ�⸦ 1/2�� ��ҽ�Ŵ
		}
		
		return deleteItem; // ������� ����
	}
	
	public E getIndexElement(int idx) { // ������ �ε����� ��Ҹ� ������
		return elements[idx];
	}
	
	public void print() { // ���� �迭�� ��Ȳ ���
		for(int i = 0; i < capacity; i++) { // �迭�� ũ�⸸ŭ ���
			if(elements[i] != null) { // ��Ұ� ������� �ʴٸ�
				System.out.print(elements[i] + "\t"); // ��ҵ��� ����ϰ�
			} else { // �׷��� �ʴٸ�
				System.out.print("null" + "\t"); // null�� ���
			}
		}
		
		System.out.println();
	}
}
