package week3.day2;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

public class SortingUsingCollection {
	public static void main(String[] args) {
		String[] input = {"HCL","Wipro","Aspire Systems","CTS"};
//		Declare a String array and add the Strings values as (HCL, Wipro,  Aspire Systems, CTS)		
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0; i<input.length; i++){
			list.add(input[i]);
		}
		Collections.sort(list);
		for(int i=list.size()-1; i>=0; i--) {
			System.out.println(list.get(i));
		}

	}

}
