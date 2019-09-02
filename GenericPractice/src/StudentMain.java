import java.util.Arrays;

public class StudentMain {
	public static void main(String[] args) {
		Student[] a = {
				new Student(35001, "박**", "수학", 3), new Student(35002, "박**", "일문", 1),
				new Student(35003, "백**", "영어", 2), new Student(35004, "이**", "러시아", 2),
				new Student(35005, "장**", "디자인", 2), new Student(35006, "이**", "불어", 1),
				new Student(35007, "이**", "컴퓨터", 4), new Student(35008, "최**", "독어", 2),
				new Student(35009, "김**", "컴퓨터", 2), new Student(350010, "정**", "정치", 4),
				new Student(350011, "형**", "영어", 4), new Student(350012, "윤**", "경제", 3),
				new Student(350013, "김**", "국문", 1), new Student(350014, "한**", "경영", 4),
				new Student(350015, "박**", "수학", 1)	
		};
		
		Arrays.sort(a); // 학번으로 정렬
		print(a, "id");
		
		Arrays.sort(a, Student.WITH_DEPT); // 학과로 정렬
		print(a, "학과");
		
		Arrays.sort(a, Student.WITH_NAME); // 이름으로 정렬
		print(a, "이름");
		
		Arrays.sort(a, Student.WITH_GRADE); // 학년으로 정렬
		print(a, "학년");
	}
	
	public static void print(Student[] a, String key) {
		System.out.println();
		System.out.println("			" + key + "(으)로 정렬하기.");
		System.out.println("-----------------------------------");
		
		for(Student temp : a) {
			System.out.println(temp.getID() + " " + temp.getName() + " " + temp.getDept() + " \t" + temp.getGrade() + "\n");
		}
	}
}
