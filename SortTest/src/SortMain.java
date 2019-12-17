import java.util.Random;

public class SortMain {
	public static void main(String[] args) {
		long start, end; // ����ð��� ���ϱ� ���� longŸ�� ����
		Random random = new Random(); // �����Լ��� �̿��ϱ� ���� ������ü
		Integer[] dataArray1 = new Integer[100]; // 0~99
		Integer[] dataArray2 = new Integer[1000]; // 0~999
		Integer[] dataArray3 = new Integer[10000]; // 0~9999
		
		for(int i = 0; i < dataArray1.length; i++) {
			dataArray1[i] = random.nextInt(100); // 0~99������ ���� ����
		}

		for(int i = 0; i < dataArray2.length; i++) {
			dataArray2[i] = random.nextInt(1000); // 0~999������ ���� ����
		}
		
		for(int i = 0; i < dataArray3.length; i++) {
			dataArray3[i] = random.nextInt(10000); // 0~9999������ ���� ����
		}
		
		System.out.print("�Է� ������1�� ��� >> ");
		for(int i = 0; i < dataArray1.length; i++) { // data1�� ���� ��� ���
			System.out.print(dataArray1[i] + " ");
		}
		System.out.println();
		
		Selection select = new Selection(); // �������� ��ü ����
		
		start = System.currentTimeMillis(); // �������� �� �ð�
		select.sort(dataArray1); //���� ���� ����
		end = System.currentTimeMillis(); // �������� �� �ð�
		end = end - start; // �� �ð��� ���� ����ð��� ��������
		
		System.out.print("���� ���� �� �Է� ������1�� ��� >> ");
		for(int i = 0; i < dataArray1.length; i++) { // ���ĵ� data1�� ���� ��� ���
			System.out.print(dataArray1[i] + " ");
		}
		System.out.println();
		System.out.println("����ð� : " + end);
		
		Quick quick = new Quick(); // ������ ��ü ����
		
		start = System.currentTimeMillis(); // ������ �� �ð�
		quick.sort(dataArray1); // �� ���� ����
		end = System.currentTimeMillis(); // ������ �� �ð�
		end = end - start;
		
		System.out.print("�� ���� �� �Է� ������1�� ��� >> ");
		for(int i = 0; i < dataArray1.length; i++) { // ���ĵ� data1�� ���� ��� ���
			System.out.print(dataArray1[i] + " ");
		}
		System.out.println();
		System.out.println("����ð� : " + end);
		
		System.out.print("�Է� ������2�� ��� >> ");
		for(int i = 0; i < dataArray2.length; i++) { // data2�� ���� ��� ���
			System.out.print(dataArray2[i] + " ");
		}
		System.out.println();
		
		start = System.currentTimeMillis(); // �������� �� �ð�
		select.sort(dataArray2); //���� ���� ����
		end = System.currentTimeMillis(); // �������� �� �ð�
		end = end - start;
		
		System.out.print("���� ���� �� �Է� ������2�� ��� >> ");
		for(int i = 0; i < dataArray2.length; i++) { // ���ĵ� data2�� ���� ��� ���
			System.out.print(dataArray2[i] + " ");
		}
		System.out.println();
		System.out.println("����ð� : " + end);
		
		start = System.currentTimeMillis(); // �� ���� �� �ð�
		quick.sort(dataArray2); // �� ���� ����
		end = System.currentTimeMillis(); // �� ���� �� �ð�
		end = end - start;
		
		System.out.print("�� ���� �� �Է� ������2�� ��� >> ");
		for(int i = 0; i < dataArray2.length; i++) { // ���ĵ� data2�� ���� ��� ���
			System.out.print(dataArray2[i] + " ");
		}
		System.out.println();
		System.out.println("����ð� : " + end);
		
		System.out.print("�Է� ������3�� ��� >> ");
		for(int i = 0; i < dataArray3.length; i++) { // data2�� ���� ��� ���
			System.out.print(dataArray3[i] + " ");
		}
		System.out.println();
		
		start = System.currentTimeMillis(); // �������� �� �ð�
		select.sort(dataArray3); //���� ���� ����
		end = System.currentTimeMillis(); // �������� �� �ð�
		end = end - start;
		
		System.out.print("���� ���� �� �Է� ������3�� ��� >> ");
		for(int i = 0; i < dataArray3.length; i++) { // ���ĵ� data2�� ���� ��� ���
			System.out.print(dataArray3[i] + " ");
		}
		System.out.println();
		System.out.println("����ð� : " + end);
		
		start = System.currentTimeMillis(); // �� ���� �� �ð�
		quick.sort(dataArray3); // �� ���� ����
		end = System.currentTimeMillis(); // �� ���� �� �ð�
		end = end - start;
		
		System.out.print("�� ���� �� �Է� ������3�� ��� >> ");
		for(int i = 0; i < dataArray3.length; i++) { // ���ĵ� data2�� ���� ��� ���
			System.out.print(dataArray3[i] + " ");
		}
		System.out.println();
		System.out.println("����ð� : " + end);
	}
}
