package strong_connected_components;

import java.util.List;
import java.util.function.Consumer;

import strong_connected_components.sscinterface.SortingProcedure;

public class SCCFinder {

	private int executionTime = 0;
	// Is used to let dfsSortForward use only one parameter in the same way as dfsSortReverse
	// and hence to enable possibility of passing both methods through Consumer interface.
	private Vertex1 sccVertex;
	
	public void sort(Graph1 g, SortingProcedure sort, Consumer<Vertex1> consumer) {
		List<Vertex1> vertices = sort.sort(g); 
		Vertex1 vStart = vertices.get(g.getAll().size() - 1);

		// it has no sense for first invocation(reverse), only for the second(forward)
		sccVertex = vStart;
		consumer.accept(vStart);
		
		for (int i = vertices.size() - 2; i>=0; i--) {
			Vertex1 v = vertices.get(i);
			if (!v.isVisited()) {
				// it has no sense for first invocation(reverse), only for the second(forward)
				sccVertex = v;
				consumer.accept(v);
			}
		}
		
		System.out.println("End");
	}

	public void dfsSortReverse(Vertex1 s) {
		s.setVisited();

		// if this isn't a sink vertex
		if (s.getHeads().size() != 0) {
			for (Vertex1 t : s.getHeads()) {
				if (!t.isVisited()) {
					dfsSortReverse(t);
				}
			}
		}

		s.setSearchTime(++executionTime);
	}
	
	public void dfsSortForward(Vertex1 s) {
		s.setVisited();
		s.setSccNumber(sccVertex.getSearchTime());
		
		// if this isn't a sink vertex
		if (s.getHeads().size() != 0) {
			for (Vertex1 t : s.getTails()) {
				if (!t.isVisited()) {
					dfsSortForward(t);
				}
			}
		}
	}
	
}
