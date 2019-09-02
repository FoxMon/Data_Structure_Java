import java.util.Comparator;

public class Student implements Comparable<Student> {
	public static final Comparator<Student> WITH_NAME = new WithName();
	public static final Comparator<Student> WITH_DEPT = new WithDept();
	public static final Comparator<Student> WITH_GRADE = new WithGrade();
	
	private int id; // �й�
	private int grade; // �г�
	private String name; // �̸�
	private String dept; // �а�
	
	public Student(int id, String name, String dept, int grade) { // Student��ü ������
		this.id = id; // �й�
		this.grade = grade; // �г�
		this.name = name; // �̸�
		this.dept = dept; // �а�
	}
	
	public int getID() { // �й� ������
		return this.id;
	}
	
	public int getGrade() { // �г� ������
		return this.grade;
	}
	
	public String getName() { // �̸� ������
		return this.name;
	}
	
	public String getDept() { // �а� ������
		return dept;
	}
	
	public static class WithName implements Comparator<Student> { // �̸����� ���ϴ� compare�޼ҵ�
		@Override
		public int compare(Student s1, Student s2) {
			return s1.name.compareTo(s2.name);
		}
	}
	
	public static class WithDept implements Comparator<Student>{ // �а��̸����� ���ϴ� compare�޼ҵ�
		@Override
		public int compare(Student s1, Student s2) {
			return s1.dept.compareTo(s2.dept);
		}
	}
	
	public static class WithGrade implements Comparator<Student>{ // �г����� ���ϴ� compare�޼ҵ�
		@Override
		public int compare(Student s1, Student s2) {
			return s1.grade - s2.grade;
		}
	}
	
	@Override 
	public int compareTo(Student s1){ // �й����� ���ϴ� compare�޼ҵ�
		return this.id - s1.id;
	}
}
