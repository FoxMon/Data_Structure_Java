package Sort;

public class LSDsort {
	public static void sort(int[] a) {
		int R = 10;
		int N = a.length;
		int[] t = new int[N];
		
		for(int k = 10; k <= 1000; k *=10) {
			int[] startIndex = new int[R+1];
			
			for(int i = 0; i < N; i++) { // 빈도수 계산
				startIndex[(a[i]%k)/(k/10) + 1]++;
			}
			
			for(int r = 0; r < R; r++) { // 각 버킷 인덱스 값이 저장될 비열 t의 시작 인데스 계산
				startIndex[r+1] += startIndex[r];
			}
			
			for(int i = 0; i < N; i++) { // a[i]를 배열 t에 차례로 저장
				t[startIndex[(a[i]%k)/(k/10)]++] = a[i];
			}
			
			for(int i = 0; i < N; i++) { // 배열 t를 배열 a로 복사
				a[i] = t[i];
			}
		}
	}
}