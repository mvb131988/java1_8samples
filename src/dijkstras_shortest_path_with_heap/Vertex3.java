package dijkstras_shortest_path_with_heap;

import java.util.ArrayList;
import java.util.List;

public class Vertex3 {

	private int number;
	private int shortPath;
	private List<Edge3> edges;
	
	public Vertex3() {
		
	}
	
	public Vertex3(int number) {
		super();
		this.number = number;
		this.shortPath = Integer.MAX_VALUE;
		this.edges = new ArrayList<>();
	}

	public void addEdge(Edge3 ed) {
		edges.add(ed);
	}
	
	public List<Edge3> getEdges() {
		return edges;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public int hashCode() {
		return number;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex3 other = (Vertex3) obj;
		if (number != other.number)
			return false;
		return true;
	}

	public int getShortPath() {
		return shortPath;
	}

	public void setShortPath(int shortPath) {
		this.shortPath = shortPath;
	}
	
}
