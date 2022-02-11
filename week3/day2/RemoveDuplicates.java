package week3.day2;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
	public static void main(String[] args) {
//		https://github.com/TestLeafPages/SelJulyPseudo/blob/master/week3/day2/classroom/RemoveDuplicates.java
//		https://github.com/TestLeafPages/SelJulyPseudo/blob/master/week3/day2/classroom/SortingUsingCollection.java
		String name = "PayPal India";
		char[] nameCharArray = name.toCharArray();
		Set<Character> charSet = new LinkedHashSet<Character>();
		Set<Character> dupCharSet = new LinkedHashSet<Character>();
		
		for (int i=0; i<nameCharArray.length; i++) {
//			if((!(charSet.contains(nameCharArray[i]))) && !(Character.isSpaceChar(nameCharArray[i]))) {
//				charSet.add(nameCharArray[i]);
//			}else {
//				dupCharSet.add(nameCharArray[i]);
//			}
			if(!(Character.isSpaceChar(nameCharArray[i]))) {
				charSet.add(nameCharArray[i]);
			}
		}
		ArrayList<Character> list = new ArrayList<Character>(charSet);
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i));
		}
	}

}
