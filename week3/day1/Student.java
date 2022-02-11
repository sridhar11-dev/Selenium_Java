package week3.day1;

public class Student extends Department{
	public void studentName() {
		System.out.println("Student Name: Sridhar");
	}
	
	public void studentDept() {
		System.out.println("Student Dept: EEE");
	}
	
	public void studentId() {
		System.out.println("studentId: 1234");
	}
	
	public static void main(String[] args) {
		Student obj = new Student();
		obj.collegeName();
		obj.collegeCode();
		obj.collegeRank();
		obj.deptName();
		obj.studentName();
		obj.studentDept();
		obj.studentId();
	}

}
