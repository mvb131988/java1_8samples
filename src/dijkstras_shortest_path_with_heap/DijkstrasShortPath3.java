package dijkstras_shortest_path_with_heap;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstrasShortPath3 {

	public void execute(Graph3 g, int startVertex) {
		PriorityQueue<Vertex3> heap = initHeap(g, startVertex);
		printHeap(heap);

		// Set vertices subset with defined short path;
		Set<Vertex3> X = new HashSet<>();
		Vertex3 newV = g.getVertexByNumber(startVertex);
		newV.setShortPath(0);
		X.add(newV);

		while (!heap.isEmpty()) {
			for (Edge3 ed : newV.getEdges()) {
				Vertex3 candidate = ed.getTail();
				if (!X.contains(candidate)) {
					int dijkstrasDistance = newV.getShortPath() + ed.getWeight();
					if (dijkstrasDistance < candidate.getShortPath()) {
						// Performs in linear time!!!
						// Priority queue implementation is unsuitable for this
						// algorithm,
						// because I can hold element position into Vertex3 and
						// hence remove it
						// in O(1) instead of O(n).
						heap.remove(candidate);
						// rewrite short path
						candidate.setShortPath(dijkstrasDistance);
						// return vertex to the heap
						heap.add(candidate);
					}
				}
			}

			// extract min from the heap
			newV = heap.poll();
			X.add(newV);
		}
	}

	private PriorityQueue<Vertex3> initHeap(Graph3 g, int startVertex) {
		PriorityQueue<Vertex3> pq = new PriorityQueue<>(
				(v1, v2) -> ((Vertex3) v1).getShortPath() == ((Vertex3) v2).getShortPath() ? 0
						: ((Vertex3) v1).getShortPath() < ((Vertex3) v2).getShortPath() ? -1 : 1);
		List<Vertex3> l = g.getVertices();
		for (Vertex3 v : l) {
			if (v.getNumber() != startVertex) {
				pq.add(v);
			}
		}
		return pq;
	}

	private void printHeap(PriorityQueue<Vertex3> heap) {
		Iterator<Vertex3> it = heap.iterator();
		while (it.hasNext()) {
			Vertex3 v = it.next();
			System.out.print(v.getNumber() + "(" + v.getShortPath() + "), ");
		}
		System.out.println();
		System.out.println(heap);
	}

}
