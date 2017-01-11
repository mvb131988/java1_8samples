package heap_for_median;

import java.util.Scanner;

public class Main {

	/**
	 * From keyboard are entered numbers. Each number is remembered, each new is added to a collection 
	 * of previously entered. The goal is to define collection's median after each input, not using linear scan. 
	 */
	public static void main(String[] args) {
		MedianSearcher searcher = new MedianSearcher();
		boolean brakeLoop = false;
		Scanner in = new Scanner(System.in);
		
		while (!brakeLoop) {
			try {
				searcher.add(in.nextInt());
				searcher.printHeapLow();
				searcher.printHeapHigh();
				searcher.printSorted();
				searcher.printMedian();
			} catch (Exception e) {
				brakeLoop = true;
			}
		}
		
		in.close();
	}

}
