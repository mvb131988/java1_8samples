package dijkstras_shortest_path;

import java.util.HashSet;
import java.util.Set;

public class DijkstrasShortPath {

	public void execute(Graph2 g, int startVertex) {
		// Set vertices subset with defined short path;
		Set<Vertex2> X = new HashSet<>();
		Vertex2 sv = g.getVertexByNumber(startVertex);
		sv.setShortPath(0);
		X.add(sv);

		Edge2 shortEdge;
		int shortDistance;
		do {
			// must be reset for each new iteration
			shortEdge = null;
			shortDistance = Integer.MAX_VALUE;

			for (Vertex2 v : X) {

				// check if vertex not a sink and has outbound edges
				if (g.getVertexEdges(v) != null) {

					// check each edge of current vertex from X
					for (Edge2 edge : g.getVertexEdges(v)) {
						Vertex2 vTail = g.getVertexByNumber(edge.getTail());

						// only if tail not in X
						if (!X.contains(vTail)) {
							Vertex2 vHead = g.getVertexByNumber(edge.getHead());

							int dijkstrasDistance = vHead.getShortPath() + edge.getWeight();
							if (dijkstrasDistance < shortDistance) {
								shortDistance = dijkstrasDistance;
								shortEdge = edge;
							}
						}
					}
					
				}

			}

			// if not the whole graph was detoured
			if (shortEdge != null) {
				// adding vertex
				Vertex2 vNew = g.getVertexByNumber(shortEdge.getTail());
				vNew.setShortPath(shortDistance);
				X.add(vNew);
			}
		} while (shortEdge != null);
	}

}
