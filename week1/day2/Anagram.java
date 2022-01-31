package week1.day2;

import java.util.Arrays;

public class Anagram {
	public static void main(String[] args) {
		String text1 = "stops";
		String text2 = "potss";
		char[] charArrayText1 = text1.toCharArray();
		char[] charArrayText2 = text2.toCharArray();
		Arrays.sort(charArrayText1);
		Arrays.sort(charArrayText2);
		boolean flag = false;
		if(text1.length() != text2.length()) {
			System.out.println("Not a Anagram");
		}else {
			for(int i=0; i<text1.length(); i++) {
				if(charArrayText1[i] == charArrayText2[i]) {
					flag = true;
				}else {
					flag = false;
					break;
				}
			}
			if(flag == true) {
				System.out.println("Anagram");
			}else {
				System.out.println("Not a Anagram");
			}
		}
	}		
}
