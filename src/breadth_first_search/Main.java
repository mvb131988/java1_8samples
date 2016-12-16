package breadth_first_search;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

	public static void main(String[] args) {
		int[][] input1 = getInput1();
		int[][] input2 = getInput2();
		int[][] input3 = getInput3();
		new BreadthFirstSearch(input3).detourAll(input3);
	}

	private static int[][] getInput1() {
		// Each ist element of edges corresponds to (i+1)st vertex of the graph.
		// edges[i] - contains vertices incident to vertex (i+1).
		// Example:
		// Vertices incident to vertex 1 are in array edges[0] = {2,3}.
		// Thus graph contains edges 1-2 and 1-3.
		int[][] edges = new int[][] {
				// 1st vertex
				{ 2, 3 },
				// 2st vertex
				{ 5, 4, 1 }, 
				{ 1, 4 }, 
				{ 2, 3, 6 }, 
				{ 2 }, 
				{ 4 } };
		
		return edges;
	}

	private static int[][] getInput2() {
		int graphSize = 1000;

		// generate first row
		int[] edgeVertexOne = new int[ThreadLocalRandom.current().nextInt(1, graphSize + 1)];
		int max = 0;
		for (int j = 0; j < edgeVertexOne.length; j++) {
			int incidentVertex = ThreadLocalRandom.current().nextInt(1, graphSize + 1);
			edgeVertexOne[j] = incidentVertex;
			if (incidentVertex > max) {
				max = incidentVertex;
			}
		}

		int vertexCount = max;
		int[][] edges = new int[vertexCount][];
		edges[0] = edgeVertexOne;

		for (int i = 1; i < edges.length; i++) {
			int edgeCount = ThreadLocalRandom.current().nextInt(1, graphSize + 1) / (i * 10) + 1;
			edges[i] = new int[edgeCount];
			for (int j = 0; j < edgeCount; j++) {
				int incidentVertex = ThreadLocalRandom.current().nextInt(1, max + 1);
				edges[i][j] = incidentVertex;
			}
		}
		
		return edges;
	}

	private static int[][] getInput3() {
		int[][] edges = new int[][] {
				// 1st vertex
				{5, 3},
				// 2st vertex
				{4}, 
				{ 1, 5}, 
				{ 2 }, 
				{ 1,3,7,9}, 
				{ 8, 10 },
				{5,9},
				{6,10},
				{5},
				{6,8}};

		return edges;
	}

}
