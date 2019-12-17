package Sort;

public class BucketSort {
	public static void sort(int[] a, int R) {
		int[] bucket = new int[R];
		
		for(int i = 0; i < R; i++) { // 초기화
			bucket[i] = 0;
		}
		
		for(int i = 0; i < a.length; i++) { // a의 원소가 bucket배열의 인덱스가 됨
			bucket[a[i]]++;  // 즉 빈도수를 계산하게 되는 것임 ( STEP 1. )
		}
		
		int j = 0;
		
		for(int i = 0; i < R; i++) { // ( STEP 2. )
			while((bucket[i]--) != 0) { // 버킷 i에 저장된 빈도수가 0이 될 때까지
				a[j++] = i; // 버킷 인덱스 i를 저장
			}
		}
	}
}
