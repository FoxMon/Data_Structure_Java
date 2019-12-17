import java.lang.Comparable;

public class Quick { // 퀵정렬
	public static void sort(Comparable[] a) { // Pivot보다 작은 값들은 좌우로 나눔
		sort(a, 0, a.length - 1);	
	}
	
	private static void sort(Comparable[] a, int low, int high) { 
		if(high <= low) { // 종료시점
			return; // 둘이 교차하는 시점이 종료시점임
		}
		
		int j = partition(a, low, high);
		
		sort(a, low, j - 1); // 피벗보다 작은 부분을 재귀적으로 처리
		sort(a, j+1, high); // 피벗보다 큰 부분을 재귀적으로 처리
	}
	
	private static int partition(Comparable[] a, int pivot, int high) {
		int i = pivot + 1;
		int j = high;
		Comparable p = a[pivot];
		
		while(true) {
			while(i <= high && !isless(p, a[i])) { // pivot보다 작으면
				i++; // i를 증가시키고
			}
			
			while(j >= pivot && isless(p, a[j])) { // pivot보다 크면
				j--; // j를 감소시킴
			}
			
			if(i >= j) { // 재귀함수 종료시점
				break; // i와 j가 만나면 둘이 교환
			}
		}
		
		swap(a, pivot, j); // j의 위치가 pivot의 위치가 되고
		
		return j; // j의 Index를 반환하면 됨
	}
	
	private static boolean isless(Comparable i, Comparable j) { // 단순 두 원소 비교
		return (i.compareTo(j) < 0); // i가 작으면 참
	}
	
	private static void swap(Comparable[] a, int i, int j) { // 단순 두 원소 교환
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
