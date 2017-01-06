package dijkstras_shortest_path;

public class Main {

	public static void main(String[] args) {
		Graph2 g = new Graph2(getInput2(), 8);
		System.out.println(g.toString());
		
		new DijkstrasShortPath().execute(g, 1);
		
		System.out.println(g.toString());
	}
	
	private static int[][] getInput1() {
		// edgesWeight[0] - head
		// edgesWeight[1] - tail
		// edgesWeight[2] - weight
		int[][] edgesWeight = new int[][] {
			{1,2,1},
			{1,3,4},
			{2,3,2},
			{2,4,6},
			{3,4,3}
		};

		return edgesWeight;
	}

	private static int[][] getInput2() {
		int[][] edgesWeight = new int[][] {
			{1,2,1},
			{1,3,2},
			{1,4,3},
			{2,3,1},
			{2,5,3},
			{3,6,6},
			{3,7,1},
			{4,3,1},
			{4,7,5},
			{5,6,7},
			{6,8,1},
			{7,8,2},
		};
		
		return edgesWeight;
	}
	
}
