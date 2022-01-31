package week1.day2;

public class ReverseEvenWords {
	public String reverse(String s) {
		String reversedString = "";
		char[] charArray = s.toCharArray();
		for(int i=charArray.length-1; i>=0; i--) {
			reversedString = reversedString + charArray[i];
		}
		return reversedString;
	}
	public static void main(String[] args) {
		String test = "I am a software tester"; 
		String result = "";
		String[] testWords = test.split(" ");
		ReverseEvenWords object = new ReverseEvenWords();
		for(int i=0; i<testWords.length; i++) {
			if(i%2 != 0)
			{
				testWords[i] = object.reverse(testWords[i]);
			}
		}
		for(int i=0; i<testWords.length; i++)
		{
			result = result.concat(testWords[i]) + " ";
		}
		System.out.println(result);
	}

}
