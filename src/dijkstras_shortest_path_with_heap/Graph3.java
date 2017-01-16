package dijkstras_shortest_path_with_heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Graph3 {

	private Map<Integer, Vertex3> v = new HashMap<>();

	// edgesWeight[0] - head
	// edgesWeight[1] - tail
	// edgesWeight[2] - weight
	public Graph3(int[][] weightEdges, int vertexNumber) {
		for (int i = 0; i < vertexNumber; i++) {
			v.put(i + 1, new Vertex3(i + 1));
		}

		for (int[] ed : weightEdges) {
			this.v.get(ed[0]).addEdge(new Edge3(this.v.get(ed[0]), this.v.get(ed[1]), ed[2]));
		}
	}

	@Override
	public String toString() {
		String output = "";
		for (Entry<Integer, Vertex3> en : v.entrySet()) {
			output += en.getKey() + "(" + en.getValue().getShortPath() + ") -> ";
			for (Edge3 v : en.getValue().getEdges()) {
				output += v.getTail().getNumber() + ", ";
			}
			output += "\r\n";
		}
		return output;
	}

	public Vertex3 getVertexByNumber(Integer number) {
		return v.get(number);
	}

	public List<Vertex3> getVertices() {
		List<Vertex3> l = new ArrayList<>();
		for(Entry<Integer, Vertex3> en: v.entrySet()) {
			l.add(en.getValue());
		}
		return l;
	}
	
}
