import java.util.Random;

public class SortMain {
	public static void main(String[] args) {
		long start, end; // 수행시간을 구하기 위한 long타입 변수
		Random random = new Random(); // 랜덤함수를 이용하기 위한 랜덤객체
		Integer[] dataArray1 = new Integer[100]; // 0~99
		Integer[] dataArray2 = new Integer[1000]; // 0~999
		Integer[] dataArray3 = new Integer[10000]; // 0~9999
		
		for(int i = 0; i < dataArray1.length; i++) {
			dataArray1[i] = random.nextInt(100); // 0~99까지의 랜덤 정수
		}

		for(int i = 0; i < dataArray2.length; i++) {
			dataArray2[i] = random.nextInt(1000); // 0~999까지의 랜덤 점수
		}
		
		for(int i = 0; i < dataArray3.length; i++) {
			dataArray3[i] = random.nextInt(10000); // 0~9999까지의 랜덤 정수
		}
		
		System.out.print("입력 데이터1의 결과 >> ");
		for(int i = 0; i < dataArray1.length; i++) { // data1의 정보 모두 출력
			System.out.print(dataArray1[i] + " ");
		}
		System.out.println();
		
		Selection select = new Selection(); // 삽입정렬 객체 생성
		
		start = System.currentTimeMillis(); // 선택정렬 전 시간
		select.sort(dataArray1); //선택 정렬 수행
		end = System.currentTimeMillis(); // 선택정렬 후 시간
		end = end - start; // 두 시간을 빼면 수행시간이 구해진다
		
		System.out.print("선택 정렬 후 입력 데이터1의 결과 >> ");
		for(int i = 0; i < dataArray1.length; i++) { // 정렬된 data1의 정보 모두 출력
			System.out.print(dataArray1[i] + " ");
		}
		System.out.println();
		System.out.println("수행시간 : " + end);
		
		Quick quick = new Quick(); // 퀵정렬 객체 생성
		
		start = System.currentTimeMillis(); // 퀵정렬 전 시간
		quick.sort(dataArray1); // 퀵 정렬 수행
		end = System.currentTimeMillis(); // 퀵정렬 후 시간
		end = end - start;
		
		System.out.print("퀵 정렬 후 입력 데이터1의 결과 >> ");
		for(int i = 0; i < dataArray1.length; i++) { // 정렬된 data1의 정보 모두 출력
			System.out.print(dataArray1[i] + " ");
		}
		System.out.println();
		System.out.println("수행시간 : " + end);
		
		System.out.print("입력 데이터2의 결과 >> ");
		for(int i = 0; i < dataArray2.length; i++) { // data2의 정보 모두 출력
			System.out.print(dataArray2[i] + " ");
		}
		System.out.println();
		
		start = System.currentTimeMillis(); // 선택정렬 전 시간
		select.sort(dataArray2); //선택 정렬 수행
		end = System.currentTimeMillis(); // 선택정렬 후 시간
		end = end - start;
		
		System.out.print("선택 정렬 후 입력 데이터2의 결과 >> ");
		for(int i = 0; i < dataArray2.length; i++) { // 정렬된 data2의 정보 모두 출력
			System.out.print(dataArray2[i] + " ");
		}
		System.out.println();
		System.out.println("수행시간 : " + end);
		
		start = System.currentTimeMillis(); // 퀵 정렬 전 시간
		quick.sort(dataArray2); // 퀵 정렬 수행
		end = System.currentTimeMillis(); // 퀵 정렬 후 시간
		end = end - start;
		
		System.out.print("퀵 정렬 후 입력 데이터2의 결과 >> ");
		for(int i = 0; i < dataArray2.length; i++) { // 정렬된 data2의 정보 모두 출력
			System.out.print(dataArray2[i] + " ");
		}
		System.out.println();
		System.out.println("수행시간 : " + end);
		
		System.out.print("입력 데이터3의 결과 >> ");
		for(int i = 0; i < dataArray3.length; i++) { // data2의 정보 모두 출력
			System.out.print(dataArray3[i] + " ");
		}
		System.out.println();
		
		start = System.currentTimeMillis(); // 선택정렬 전 시간
		select.sort(dataArray3); //선택 정렬 수행
		end = System.currentTimeMillis(); // 선택정렬 후 시간
		end = end - start;
		
		System.out.print("선택 정렬 후 입력 데이터3의 결과 >> ");
		for(int i = 0; i < dataArray3.length; i++) { // 정렬된 data2의 정보 모두 출력
			System.out.print(dataArray3[i] + " ");
		}
		System.out.println();
		System.out.println("수행시간 : " + end);
		
		start = System.currentTimeMillis(); // 퀵 정렬 전 시간
		quick.sort(dataArray3); // 퀵 정렬 수행
		end = System.currentTimeMillis(); // 퀵 정렬 후 시간
		end = end - start;
		
		System.out.print("퀵 정렬 후 입력 데이터3의 결과 >> ");
		for(int i = 0; i < dataArray3.length; i++) { // 정렬된 data2의 정보 모두 출력
			System.out.print(dataArray3[i] + " ");
		}
		System.out.println();
		System.out.println("수행시간 : " + end);
	}
}
