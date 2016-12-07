package quicksearch;

import java.util.Arrays;

public class QuickSearch {

	public static void main(String[] args) {
		//int[] input = new int[] {19,6,8,13,17,10,15,4,7,1,12,2,20,9,16,5,11,14,3,21,18};
//		Arrays.sort(input);
		
		int[] input = new int[100];
		for(int i=0; i<100; i++) {
			input[i] = (int) (Math.random()*1000);
		}
		DSelect dSelect = new DSelect();
		System.out.println(dSelect.find(input, 17));
		Arrays.sort(input);
		System.out.println(Arrays.toString(input));
	}
	
}
