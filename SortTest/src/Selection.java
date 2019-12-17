import java.lang.Comparable;

public class Selection { // 삽입정렬
	public static void sort(Comparable[] a) { 
		int N = a.length;
		
		for(int i = 0; i < N; i++) { // 배열 a의 크기만큼 반복문 수행
			int min = i; // 첫 번째 원소가 정렬돼 있다고 가정하고 수행
			
			for(int j = i + 1; j < N; j++) { // 두 번째 원소부터 비교
				if(isless(a[j], a[min])) { // min보다 작으면
					min = j; // min Index를 j로 교환
				}
			}
			
			swap(a, i, min); // 원소도 바꿔줌
		}
	}
	
	private static boolean isless(Comparable i, Comparable j) { // 단순 두 원소 비교
		return (i.compareTo(j) < 0 ); // i가 0보다 작으면 참 
	}
	
	private static void swap(Comparable[] a, int i, int j) { // 단순 두 원소 교환
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
