package strong_connected_components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import strong_connected_components.sscinterface.TailOrHead;

public class Graph1 {

	private Vertex1[] vertices;

	public Graph1(List<Vertex1> vertices) {
		this.vertices = new Vertex1[vertices.size()];
		for (int i = 0; i < vertices.size(); i++) {
			this.vertices[i] = vertices.get(i);
		}
	}

	/**
	 * 
	 * @param vertices
	 *            - ordered array of vertices in graph. vertices[0] binds with
	 *            1st vertex, vertices[1] with 2nd and so on.
	 */
	public Graph1(int[][] vertices) {
		this.vertices = new Vertex1[vertices.length];
		for (int i = 0; i < vertices.length; i++) {
			this.vertices[i] = new Vertex1(i + 1);
		}

		for (int i = 0; i < vertices.length; i++) {
			Vertex1 head = getVertex(i + 1);
			Vertex1[] tails = new Vertex1[vertices[i].length];
			for (int j = 0; j < tails.length; j++) {
				tails[j] = getVertex(vertices[i][j]);
			}
			head.setTails(Arrays.asList(tails));
		}
	}

	public Graph1 reverse() {
		List<Vertex1> reverseGraph = new ArrayList<Vertex1>(vertices.length);
		getAll().forEach(tail -> {
			reverseGraph.add(tail);
			tail.setHeads(new ArrayList<Vertex1>());
			getAll().forEach(head -> {
				if (tail != head) {
					head.getTails().forEach(v -> {
						System.out.println("Head " + v + " tail " + tail);
 						if (v == tail) {
							tail.getHeads().add(head);
						}
					});
				}
			});
		});
		return new Graph1(reverseGraph);
	}

	public Vertex1 getVertex(int number) {
		return this.vertices[number - 1];
	}

	public String toString(TailOrHead selector) {
		String s = "";
		for (Vertex1 h : vertices) {
			s += h.getNumber() + "(" + h.getSearchTime() + ", " + h.getSccNumber() + ")" + " -> ";
			for (Vertex1 t : selector.select(h)) {
				s += t.getNumber() + ", ";
			}
			s += "\r\n";
		}
		return s;
	}

	public int size() {
		return vertices.length;
	}

	public List<Vertex1> getAll() {
		return Arrays.asList(vertices);
	}
	
	public List<Vertex1> getAllByExecutionTime() {
		List<Vertex1> all = Arrays.asList(vertices);
		all.sort((v1, v2) -> new Integer(v1.getSearchTime()).compareTo(v2.getSearchTime()));
		return all;
	}
	
	public void sortById() {
		Arrays.asList(vertices).sort((v1, v2) -> new Integer(v1.getNumber()).compareTo(v2.getNumber()));
	}
}
