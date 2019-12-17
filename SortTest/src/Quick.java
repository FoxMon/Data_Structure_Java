import java.lang.Comparable;

public class Quick { // ������
	public static void sort(Comparable[] a) { // Pivot���� ���� ������ �¿�� ����
		sort(a, 0, a.length - 1);	
	}
	
	private static void sort(Comparable[] a, int low, int high) { 
		if(high <= low) { // �������
			return; // ���� �����ϴ� ������ ���������
		}
		
		int j = partition(a, low, high);
		
		sort(a, low, j - 1); // �ǹ����� ���� �κ��� ��������� ó��
		sort(a, j+1, high); // �ǹ����� ū �κ��� ��������� ó��
	}
	
	private static int partition(Comparable[] a, int pivot, int high) {
		int i = pivot + 1;
		int j = high;
		Comparable p = a[pivot];
		
		while(true) {
			while(i <= high && !isless(p, a[i])) { // pivot���� ������
				i++; // i�� ������Ű��
			}
			
			while(j >= pivot && isless(p, a[j])) { // pivot���� ũ��
				j--; // j�� ���ҽ�Ŵ
			}
			
			if(i >= j) { // ����Լ� �������
				break; // i�� j�� ������ ���� ��ȯ
			}
		}
		
		swap(a, pivot, j); // j�� ��ġ�� pivot�� ��ġ�� �ǰ�
		
		return j; // j�� Index�� ��ȯ�ϸ� ��
	}
	
	private static boolean isless(Comparable i, Comparable j) { // �ܼ� �� ���� ��
		return (i.compareTo(j) < 0); // i�� ������ ��
	}
	
	private static void swap(Comparable[] a, int i, int j) { // �ܼ� �� ���� ��ȯ
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
