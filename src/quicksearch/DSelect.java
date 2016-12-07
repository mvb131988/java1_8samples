package quicksearch;

import java.util.Arrays;

public class DSelect {

	public int find(int[] input, int orderStatistic) {
		System.out.println("---find---");
		System.out.println(Arrays.toString(input) + " orderStatistic = " + orderStatistic);
		
		int p = pivot(input);

		// partitioning
		// pivot index in input unsorted array
		int iPivot = 0;
		for (iPivot = 0; input[iPivot] != p; iPivot++);
		
		for (int i = iPivot; i < input.length - 1; i++) {
			input[i] = input[i + 1];
		}
		input[input.length - 1] = -1;
		
		// looking for pivot position
		// pivot position in input sorted array
		iPivot = 0;
		for (int i = 0; i < input.length - 1; i++) {
			if(input[i]<p){
				//swap if necessary
				if (iPivot < i) {
					input[iPivot] += input[i];
					input[i] = input[iPivot] - input[i];
					input[iPivot] = input[iPivot] - input[i];
				}
				iPivot ++;
			}
		}
		//shift elements from iPivot to the right
		for(int i = input.length-2; i>=iPivot; i--) {
			input[i+1] = input[i]; 
		}
		//insert pivot
		input[iPivot] = p;
		
		if((iPivot+1) > orderStatistic){
			p = find(copy(input, 0, iPivot), orderStatistic);
		}
		if((iPivot+1) < orderStatistic){
			p = find(copy(input, iPivot+1, input.length), orderStatistic - (iPivot+1));
		}
		
		//if iPivot == orderStatistic
		return p;
	}

	private int pivot(int[] input) {
		int median = -1;
		// Base step
		if (input.length <= 5) {
			MergeSort.sort(input);
			median = input[input.length / 2];
		} else { // split in sorted chunks
			int chunksCount = input.length % 5 == 0 ? input.length / 5 : input.length / 5 + 1;
			int[][] chunks = new int[chunksCount][];
			for (int i = 0; i < input.length / 5; i++) {
				chunks[i] = new int[5];
			}
			if(input.length % 5 > 0){
				chunks[chunks.length - 1] = new int[input.length % 5];
			}
			
			// current input element index
			int i = 0;
			// current chunk index
			int j = 0;
			// current element index in current chunk
			int k = 0;
			for (int e : input) {
				if ((i != 0) && ((i) % 5 == 0)) {
					MergeSort.sort(chunks[j]);
					j++;
					k = 0;
				}
				chunks[j][k] = e;
				k++;
				i++;
			}

			// round one: choose median from each chunk
			int[] medians = new int[chunksCount];
			i = 0;
			for (int[] e : chunks) {
				medians[i++] = e[e.length / 2];
			}

			median = pivot(medians);
		}
		return median;
	}
	
	private int[] copy(int[] input, int start, int stop) {
		int[] c = new int[stop-start];
		for(int i = start, j=0; i<stop; i++, j++) {
			c[j] = input[i];
		}
		return c;
	}

}
