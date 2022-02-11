package week3.day2;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class PrintDuplicatesInArray {
	public static void main(String[] args) {
		int[] arr = {14,12,13,11,15,14,18,16,17,19,18,17,20};
		LinkedHashSet<Integer> uniqNumSet = new LinkedHashSet<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<arr.length; i++) {
			if(uniqNumSet.add(arr[i]) == false) {
				list.add(arr[i]);
			}
		}
		System.out.println(list);
	}
}
