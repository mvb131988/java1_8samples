package heap;

public class Heap {

	private int[] h;
	private int size;
	private final int blockSize = 10;

	public Heap(int[] input) {
		h = new int[input.length];
		size = 0;

		for (int i : input) {
			insert(i);
		}
	}
	
	//================================================================================
	// 1. Insert operation
	//================================================================================		
	public void insert(int element) {
		ensureCapacity();
		h[size++] = element;
		ensureHeapSignUp(size - 1);
	}
	
	private void ensureHeapSignUp(int elementIndex) {
		Integer pi = parentIndex(elementIndex);
		if (pi != null && h[elementIndex] < h[pi]) {
			// swap elements
			int temp = h[pi];
			h[pi] = h[elementIndex];
			h[elementIndex] = temp;

			// ensure heap property for element with parent index
			ensureHeapSignUp(pi);
		}
	}

	private void ensureCapacity() {
		if (size == h.length) {
			int[] temp = new int[h.length + blockSize];
			for (int i = 0; i < h.length; i++) {
				temp[i] = h[i];
			}
			h = temp;
		}
	}

	private Integer parentIndex(int elementIndex) {
		if (elementIndex > 0) {
			return elementIndex % 2 == 0 ? elementIndex / 2 - 1 : elementIndex / 2;
		}
		return null;
	}
	//================================================================================

	//================================================================================
	// 2. Extract min operation
	//================================================================================	
	public int extractMin() {
		int min = h[0];

		h[0] = h[size - 1];

		// shrink h
		int[] temp = new int[size - 1];
		for (int i = 0; i < size - 1; temp[i] = h[i], i++);

		h = temp;
		size--;

		// no need to adjust heap if less than two elements remain
		if (size > 1) {
			ensureHeapSignDown(0);
		}

		return min;
	}

	private void ensureHeapSignDown(int elementIndex) {
		// min child index
		Integer minCi = minChildIndex(elementIndex);
		boolean isLeaf = minCi == null;
		boolean isHeapViolation = isLeaf ? false : h[elementIndex] > h[minCi];
		
		if (!isLeaf && isHeapViolation) {
			//swap elements
			int temp = h[elementIndex];
			h[elementIndex] = h[minCi];
			h[minCi] = temp;
			
			ensureHeapSignDown(minCi);
		}
	}

	private Integer minChildIndex(int elementIndex) {
		int leftChildIndex = 2 * elementIndex + 1;
		int rightChildIndex = 2 * elementIndex + 2;
		if (leftChildIndex >= h.length && rightChildIndex >= h.length) {
			return null;
		}
		if (leftChildIndex < h.length && rightChildIndex >= h.length) {
			return leftChildIndex;
		}
		if (leftChildIndex >= h.length && rightChildIndex < h.length) {
			return rightChildIndex;
		}
		return h[leftChildIndex] <= h[rightChildIndex] ? leftChildIndex : rightChildIndex;
	}
	//================================================================================	
	
	@Override
	public String toString() {
		String output = "";

		if (h.length > 0) {
			// level number
			int l = 0;
			// corresponding max capacity for level l
			int maxCapacity = 1;
			int currentIndex = 0;
			do {
				for (; currentIndex < maxCapacity && currentIndex < h.length; currentIndex++) {
					output += h[currentIndex] + " ";
				}
				output += "\n\r";

				l++;

				int k = 1;
				for (int i = 0; i < l; i++, k *= 2)
					;
				maxCapacity += k;
			} while (currentIndex < h.length);
		}

		return output;
	}

}
