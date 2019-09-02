import java.util.Comparator;

public class Student implements Comparable<Student> {
	public static final Comparator<Student> WITH_NAME = new WithName();
	public static final Comparator<Student> WITH_DEPT = new WithDept();
	public static final Comparator<Student> WITH_GRADE = new WithGrade();
	
	private int id; // 학번
	private int grade; // 학년
	private String name; // 이름
	private String dept; // 학과
	
	public Student(int id, String name, String dept, int grade) { // Student객체 생성자
		this.id = id; // 학번
		this.grade = grade; // 학년
		this.name = name; // 이름
		this.dept = dept; // 학과
	}
	
	public int getID() { // 학번 접근자
		return this.id;
	}
	
	public int getGrade() { // 학년 접근자
		return this.grade;
	}
	
	public String getName() { // 이름 접근자
		return this.name;
	}
	
	public String getDept() { // 학과 접근자
		return dept;
	}
	
	public static class WithName implements Comparator<Student> { // 이름으로 비교하는 compare메소드
		@Override
		public int compare(Student s1, Student s2) {
			return s1.name.compareTo(s2.name);
		}
	}
	
	public static class WithDept implements Comparator<Student>{ // 학과이름으로 비교하는 compare메소드
		@Override
		public int compare(Student s1, Student s2) {
			return s1.dept.compareTo(s2.dept);
		}
	}
	
	public static class WithGrade implements Comparator<Student>{ // 학년으로 비교하는 compare메소드
		@Override
		public int compare(Student s1, Student s2) {
			return s1.grade - s2.grade;
		}
	}
	
	@Override 
	public int compareTo(Student s1){ // 학번으로 비교하는 compare메소드
		return this.id - s1.id;
	}
}
