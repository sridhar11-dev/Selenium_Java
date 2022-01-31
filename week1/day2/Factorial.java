package week1.day2;

public class Factorial {
	public int printFactorial(int num) {
		int result = 1;
		if(num == 0)
			return 1;
		for(int i=num; i>=1; i--) {
			result = result * i;
		}
		return result;
	}
	public static void main(String[] args) {
		Factorial object = new Factorial();
		int result = object.printFactorial(5);
		System.out.println(result);
	}

}
