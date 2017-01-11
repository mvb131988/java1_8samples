package heap_for_median;

import java.util.PriorityQueue;

public class MedianSearcher {

	private PriorityQueue<Integer> heapLow = new PriorityQueue<>((v1, v2) -> v1 == v2 ? 0 : v1 > v2 ? -1 : 1);
	private PriorityQueue<Integer> heapHigh = new PriorityQueue<>((v1, v2) -> v1 == v2 ? 0 : v1 < v2 ? -1 : 1);

	public void add(Integer element) {
		if (heapLow.size() == 0 && heapHigh.size() == 0) {
			heapLow.add(element);
		} else {
			if (element <= heapLow.peek()) {
				heapLow.add(element);
			} else {
				heapHigh.add(element);
			}
		}
		balanceHeaps();
	}

	private void balanceHeaps() {
		if (heapLow.size() - heapHigh.size() > 1) {
			Integer element = heapLow.poll();
			heapHigh.add(element);
		}
		if (heapHigh.size() - heapLow.size() > 1) {
			Integer element = heapHigh.poll();
			heapLow.add(element);
		}
	}

	public void printMedian() {
		if ((heapLow.size() + heapHigh.size()) % 2 == 0) {
			System.out.println("Medians: " + heapLow.peek() + " " + heapHigh.peek());
		} else {
			if(heapLow.size() > heapHigh.size()) {
				System.out.println("Median: " + heapLow.peek());
			} else {
				System.out.println("Median: " + heapHigh.peek());
			}
		}
		
	}

	public void printHeapLow() {
		System.out.println(heapLow);
	}

	public void printHeapHigh() {
		System.out.println(heapHigh);
	}

	public void printSorted() {
		PriorityQueue<Integer> h = new PriorityQueue<>((v1, v2) -> v1 == v2 ? 0 : v1 < v2 ? -1 : 1);
		h.addAll(heapLow);
		h.addAll(heapHigh);
		int hSize = h.size();
		for (int i = 0; i < hSize; i++) {
			System.out.print(h.poll() + " ");
		}
		System.out.println();
	}

}
