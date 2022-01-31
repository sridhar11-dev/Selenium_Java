package week1.day1;

public class Student {
	String name = "Sridhar";
	int rollNo = 35104;
	
	public void College() {
		String name = "SSNCE";
		System.out.println("college name: "+name);
	}
	public static void main(String[] args) {
		Student studentObject = new Student();
		studentObject.College();
		System.out.println(studentObject.name);
		System.out.println(studentObject.rollNo);
	}
}
