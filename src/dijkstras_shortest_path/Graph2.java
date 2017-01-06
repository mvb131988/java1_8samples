package dijkstras_shortest_path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Graph2 {

	private Map<Vertex2, List<Edge2>> g = new HashMap<>();
	private Map<Integer, Vertex2> v = new HashMap<>();

	// edgesWeight[0] - head
	// edgesWeight[1] - tail
	// edgesWeight[2] - weight
	public Graph2(int[][] weightEdges, int vertexNumber) {
		for (int i = 0; i < vertexNumber; i++) {
			v.put(i + 1, new Vertex2(i + 1));
		}

		for (int[] ed : weightEdges) {
			if (g.get(v.get(ed[0])) == null) {
				Vertex2 v = this.v.get(ed[0]);
				List<Edge2> l = new ArrayList<>();
				g.put(v, l);
			}
			g.get(v.get(ed[0])).add(new Edge2(ed[0], ed[1], ed[2]));
		}
	}

	@Override
	public String toString() {
		String output = "";
		for (Entry<Integer, Vertex2> en : v.entrySet()) {
			output += en.getKey() + "(" + en.getValue().getShortPath() + ") -> ";
			if (g.get(en.getValue()) != null) {
				for (Edge2 v : g.get(en.getValue())) {
					output += v.getTail() + ", ";
				}
			}
			output += "\r\n";
		}
		return output;
	}
	
	public Vertex2 getVertexByNumber(Integer number) {
		return v.get(number);
	}
	
	public List<Edge2> getVertexEdges(Integer number) {
		return g.get(v.get(number));
	}
	
	public List<Edge2> getVertexEdges(Vertex2 v) {
		return g.get(v);
	}


}
