package deep_first_search;

public class Main {

	public static void main(String[] args) {
		Graph g = new Graph(getInput2());
		new DeepFirstSearch().topologicalSort(g,1);
		g = new Graph(getInput2());
		new DeepFirstSearch().topologicalSort(g,2);
		g = new Graph(getInput2());
		new DeepFirstSearch().topologicalSort(g,6);
		System.out.println(g);
	}
	
	private static int[][] getInput1() {
		// Each ist element of edges corresponds to (i+1)st vertex of the graph.
		// edges[i] - contains vertices incident to vertex (i+1).
		// Example:
		// Vertices incident to vertex 1 are in array edges[0] = {2,3}.
		// Thus graph contains edges 1-2 and 1-3.
		int[][] edges = new int[][] {
				{ 2, 3 },
				{ 4 }, 
				{ 4 }, 
				{ } };
		
		return edges;
	}
	
	private static int[][] getInput2() {
		int[][] edges = new int[][] { 
			{ 2, 3 }, 
			{ 5, 4 }, 
			{ 4 }, 
			{ 6 }, 
			{}, 
			{ 7, 8 }, 
			{}, 
			{ 9, 10 }, 
			{}, 
			{} };

		return edges;
	}
		
}
