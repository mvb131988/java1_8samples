package breadth_first_search;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class BreadthFirstSearch {
	
	private int[] visitedVertices;
	
	public BreadthFirstSearch(int[][] edges) {
		// If ist vertex(edges[i-1]) is visited visitedVertices[i-1] is set to
		// 1. Unvisited vertices visitedVertices[i] = 0.
		visitedVertices = new int[edges.length];
	}
	
	// startVertex - Vertex where detour starts
	public void detour(int[][] edges, int startVertex) {
		//Output result with statistic
		Vertex[] verticies = initDetouredVertices(edges);
		
		//Visit first vertex
		visitVertex(visitedVertices, verticies, startVertex, 0);
		
		Queue<Integer> q = new ArrayBlockingQueue<>(edges.length);
		q.add(startVertex);
		
		while(!q.isEmpty()) {
			int currentVertex = q.remove();
			int[] incidentVertices = edges[currentVertex - 1];
			for(int incidentVertex: incidentVertices) {
				//if not visited mark it as visited and add into the queue
				if(visitedVertices[incidentVertex-1] == 0) {
					// visit i'th vertex
					visitVertex(visitedVertices, verticies, incidentVertex, verticies[currentVertex-1].getLayer() + 1);
					q.add(incidentVertex);
				}
			}
		}
		
		System.out.println();
		Arrays.asList(verticies).forEach(i->System.out.println(i.getId() + " : " + i.getLayer() + " ( " + i.getTimesVisited() + " ) "));
	}
	
	// Detour all connected components
	public void detourAll(int[][] edges) {
		for(int i=0; i<edges.length; i++) {
			if(visitedVertices[i] != 1) {
				detour(edges,i+1);
			}
		}
	}
	
	private void visitVertex(int[] visitedVertices, Vertex[] verticies, int vertexNumber, int layer) {
		visitedVertices[vertexNumber-1] = 1;
		verticies[vertexNumber-1].incrementTimesVisited();
		verticies[vertexNumber-1].setLayer(layer);
		System.out.print(verticies[vertexNumber-1].getId() + "-");
	}
	
	private Vertex[] initDetouredVertices(int[][] edges) {
		// Output result with statistic
		Vertex[] verticies = new Vertex[edges.length];
		for (int i = 0; i < verticies.length; i++) {
			verticies[i] = new Vertex(i + 1);
		}

		return verticies;
	}
	
}
