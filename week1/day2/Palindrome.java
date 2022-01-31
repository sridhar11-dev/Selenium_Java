package week1.day2;

public class Palindrome {
	public boolean isPalindrome(String name) {
		String reversedString = "";
		for(int i=name.length()-1; i>=0; i--)
		{
			reversedString = reversedString + name.charAt(i);
		}
		if(reversedString.equals(name)) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Palindrome object = new Palindrome();
		boolean palindrome = object.isPalindrome("malayalam");
		if(palindrome) {
			System.out.println("Palindrome");
		}else {
			System.out.println("Not a Palindrome");
		}
	}
}
