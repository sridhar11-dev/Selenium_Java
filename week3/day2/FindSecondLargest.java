package week3.day2;

import java.util.ArrayList;
import java.util.Collections;

public class FindSecondLargest {
	public static void main(String[] args) {
		int[] data = {3,2,11,4,6,7};
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < data.length; i++) {
			list.add(data[i]);
		}
		Collections.sort(list);
		Collections.reverse(list);
		System.out.println(list.get(1));
	}
}
