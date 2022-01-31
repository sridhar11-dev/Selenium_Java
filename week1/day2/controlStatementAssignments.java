package week1.day2;

public class controlStatementAssignments {
	public static void main(String[] args) {
		controlStatementAssignments object = new controlStatementAssignments();
		object.printNumbers();
		object.printOddNumbers();
		object.printEvenSquares();
		object.printSumOfNumbers(5);
	}
	public void printNumbers() {
		System.out.println("Print Numbers:");
		for(int i = 1; i <=100; i++)
		{
			System.out.println(i);
		}
	}
	public void printOddNumbers() {
		System.out.println("Print Odd Numbers from 1 - 100:");
		for(int i=1; i<=100; i++)
		{
			if(i%2 != 0)
			{
				System.out.println(i);
			}
		}
	}
	public void printEvenSquares() {
		System.out.println("Print even squares from 59 - 38:");
		int result = 0;
		for(int i=59; i >=38; i--)
		{
			if(i%2 == 0)
			{
				result = i * i;
				System.out.println(result);
			}
		}
	}
	
	public void printSumOfNumbers(int num) {
		System.out.println("Print sum of given number:");
		int sum = 0;
		for(int i=1; i <= num; i++)
		{
			sum = sum + i;
		}
		System.out.println(sum);
	}

}
