package week1.day2;

public class PrimeNumber {
	public void isPrimeNumber(int num) {
		boolean flag = false;
		if (num <= 1)
		{
			System.out.println("Not a prime Number");
			return;
		}
		for (int i = 2; i < num/2; i++) {
			if(num%i == 0) {
				flag = true;
				break;
			}
		}
		if(flag) {
			System.out.println("Not a Prime");
		}else {
			System.out.println("Prime Number");
		}
	}
	public static void main(String[] args) {
		PrimeNumber object = new PrimeNumber();
		object.isPrimeNumber(13);
	}
}
