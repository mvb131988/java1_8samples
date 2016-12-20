package deep_first_search;

import java.util.Arrays;
import java.util.List;

public class Graph {
	
	private Vertex[] vertices;
	
	/**
	 * 
	 * @param vertices - ordered array of vertices in graph. vertices[0] binds with 1st vertex, 
	 * 					 vertices[1] with 2nd and so on.
	 */
	public Graph(int[][] vertices) {
		this.vertices = new Vertex[vertices.length];
		for (int i = 0; i < vertices.length; i++) {
			this.vertices[i] = new Vertex(i+1);
		}
		
		for(int i=0; i < vertices.length; i++) {
			Vertex head = getVertex(i+1); 
			Vertex[] tails = new Vertex[vertices[i].length];
			for(int j=0; j<tails.length; j++) {
				tails[j] = getVertex(vertices[i][j]);
			}
			head.setTails(tails);
		}
	}
	
	public Vertex getVertex(int number) {
		return this.vertices[number-1];
	}
	
	public String toString() {
		String s = "";
		for(Vertex h: vertices) {
			s += h.getNumber() + " -> ";
			for(Vertex t: h.getTails()) {
				s += t.getNumber() + ", ";
			}
			s += "\r\n";
		}
		return s;
	}
	
	public int size() {
		return vertices.length;
	}
	
	public List<Vertex> getAll() {
		return Arrays.asList(vertices);
	}
	
}
