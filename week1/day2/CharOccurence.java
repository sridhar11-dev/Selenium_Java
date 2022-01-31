package week1.day2;

public class CharOccurence {
	public int charOccurence(char c, char[] s) {
		int count = 0;
		for (int i = 0; i < s.length; i++) {
			if(c == s[i]) {
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		CharOccurence object = new CharOccurence();
		String str = "welcome to chennai";
		char[] strArray = str.toCharArray();
		int charOccurence = object.charOccurence('e', strArray);
		System.out.println(charOccurence);
	}
}
