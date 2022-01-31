package week1.day1;

public class Mobile {
	String msg = "Hii";
	long mobileNo = 9865546712L;
	public void sendMessage(String msg) {
		System.out.println("sent message: "+msg);
	}
	public void makeCall(long number) {
		System.out.println("calling "+ number);
	}
	public void saveContact(long number, String name) {
		System.out.println("contact saved as:");
	    System.out.println("name: "+name);
		System.out.println("mobile no: "+number);
	}
	
	public static void main(String[] args) {
		Mobile mobileObject = new Mobile();
		mobileObject.sendMessage(mobileObject.msg);
		mobileObject.makeCall(mobileObject.mobileNo);
		mobileObject.saveContact(9874657903L, "Ram");
	}
}
