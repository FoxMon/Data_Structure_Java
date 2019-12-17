import java.lang.Comparable;

public class Selection { // ��������
	public static void sort(Comparable[] a) { 
		int N = a.length;
		
		for(int i = 0; i < N; i++) { // �迭 a�� ũ�⸸ŭ �ݺ��� ����
			int min = i; // ù ��° ���Ұ� ���ĵ� �ִٰ� �����ϰ� ����
			
			for(int j = i + 1; j < N; j++) { // �� ��° ���Һ��� ��
				if(isless(a[j], a[min])) { // min���� ������
					min = j; // min Index�� j�� ��ȯ
				}
			}
			
			swap(a, i, min); // ���ҵ� �ٲ���
		}
	}
	
	private static boolean isless(Comparable i, Comparable j) { // �ܼ� �� ���� ��
		return (i.compareTo(j) < 0 ); // i�� 0���� ������ �� 
	}
	
	private static void swap(Comparable[] a, int i, int j) { // �ܼ� �� ���� ��ȯ
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
