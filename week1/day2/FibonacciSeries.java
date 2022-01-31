package week1.day2;

public class FibonacciSeries {
	public void printFibonacciSeries(int range) {
		int f1 = 0;
		int f2 = 1;
		int f3 = 0;
		System.out.println(f1);
		for (int i = 1; i < range; i++) {
			f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
			System.out.println(f3);
		}
	}
	public static void main(String[] args) {
		FibonacciSeries object = new FibonacciSeries();
		object.printFibonacciSeries(8);
	}

}
