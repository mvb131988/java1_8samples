package quicksearch;

public class MergeSort {

	public static void sort(int[] input) {
		if (input.length < 2) {
			return;
		}
		if (input.length == 2) {
			if (input[0] > input[1]) {
				input[0] += input[1];
				input[1] = input[0] - input[1];
				input[0] = input[0] - input[1];
			}
		}
		if (input.length > 2) {
			int[][] parts = new int[2][];
			parts[0] = new int[input.length / 2];
			parts[1] = new int[input.length - input.length / 2];

			// index of current element in parts[0] array
			int j = 0;
			// index of current element in parts[1] array
			int k = 0;
			for (int i = 0; i < input.length; i++) {
				if (i < input.length / 2) {
					parts[0][j] = input[i];
					j++;
				} else {
					parts[1][k] = input[i];
					k++;
				}
			}

			// sort both parts
			sort(parts[0]);
			sort(parts[1]);

			// merge two sorted arrays into one
			j = 0;
			k = 0;
			for (int i = 0; i < input.length; i++) {
				if ((j < parts[0].length) && (k < parts[1].length)) {
					if (parts[0][j] > parts[1][k]) {
						input[i] = parts[1][k];
						k++;
					} else {
						input[i] = parts[0][j];
						j++;
					}
				} else{
					if(j < parts[0].length) {
						input[i] = parts[0][j];
						j++;
					}
					if(k < parts[1].length) {
						input[i] = parts[1][k];
						k++;
					}
				}
			}
		}
	}

}
