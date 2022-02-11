package week3.day1;

public class Calculator {
	public void add(int a, int b) {
		System.out.println("sum of two numbers: " + (a+b));
	}
	
	public void add(int a, int b, int c) {
		System.out.println("sum of three numbers: " + (a+b+c));
	}
	
	public static void main(String[] args) {
		Calculator calculate = new Calculator();
		calculate.add(2, 3);
		calculate.add(3, 4, 5);
	}
}
