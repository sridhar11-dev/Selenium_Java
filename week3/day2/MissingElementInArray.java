package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MissingElementInArray {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,7,6,8};
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		
		for(int i=1; i<=arr.length; i++) {
			list.add(i);
		}
 		for(int i=0; i<arr.length; i++) {
 			arrList.add(arr[i]);
 		}
		Collections.sort(arrList);
		for(int i=0; i<arrList.size(); i++) {
			if(list.get(i) != arrList.get(i)) {
				System.out.println(list.get(i));
				break;
			}
		}
	}
}
