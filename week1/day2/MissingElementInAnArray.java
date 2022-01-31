package week1.day2;

import java.util.Arrays;

public class MissingElementInAnArray {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,7,6,8};
		Arrays.sort(arr);
		int lengthOfArray = arr.length;
		for(int i=arr[0],j=0; (i<=lengthOfArray && j < lengthOfArray); i++,j++) {
			if(i != arr[j]) {
				System.out.println(i);
				break;
			}
		}
	}
}
