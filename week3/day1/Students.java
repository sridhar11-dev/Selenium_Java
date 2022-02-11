package week3.day1;

public class Students {
	public void getStudentInfo(int id) {
		System.out.println("Student ID: "+ id);
	}
	
	public void getStudentInfo(int id, String name) {
		System.out.println("Student ID: "+ id);
		System.out.println("Student Name: "+ name);
	}
	
	public void getStudentInfo(String email, String phoneNo) {
		System.out.println("email: "+ email);
		System.out.println("phone no: "+ phoneNo);
	}
	
	public static void main(String[] args) {
		Students obj = new Students();
		obj.getStudentInfo(1);
		obj.getStudentInfo(2, "Ram");
		obj.getStudentInfo("ram@gmail.com", "9876540321");
	}
	
	
	
}
