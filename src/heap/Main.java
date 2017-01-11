package heap;

public class Main {

	public static void main(String[] args) {
		int[] input = { 15, 7, 32, 1, 17, 4, 9, 11, 18, 3, 23, 21, 10, 8, 12, 5, 13, 31, 4, 6, 14, 2, 16 };
		Heap h = new Heap(input);
		System.out.println(h);
		
		int min;
		for(int i = 0; i < input.length; i++) {
			min = h.extractMin();
//			System.out.println("Min: " + min);
//			System.out.println(h);
			System.out.print(min + " ");
		}
	}

}
