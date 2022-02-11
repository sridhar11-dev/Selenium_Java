package week3.day2;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesAssignment {
	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		char[] charArray = text.toCharArray();
		Set<Character> uniqCharSet = new LinkedHashSet<Character>();
		for(int i = 0; i<charArray.length; i++ ) {
			uniqCharSet.add(Character.toLowerCase(charArray[i]));
		}
		ArrayList<Character> list = new ArrayList<Character>(uniqCharSet);
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i));
		}
	}
}
