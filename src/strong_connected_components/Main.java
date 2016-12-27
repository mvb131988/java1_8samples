package strong_connected_components;

public class Main {

	public static void main(String[] args) {
		SCCFinder finder = new SCCFinder();
		
		Graph1 graph1 = new Graph1(getInput1());
		Graph1 graph1Reverse = graph1.reverse();
		
		finder.sort(graph1Reverse, g -> g.getAll(), finder::dfsSortReverse);
		System.out.println(graph1Reverse.toString(v->v.getHeads()));

		graph1.getAll().forEach(v->v.setVisited(false));
		finder.sort(graph1, g -> g.getAllByExecutionTime(), finder::dfsSortForward);
		graph1.sortById();
		System.out.println(graph1.toString(v->v.getTails()));
	}
	
	private static int[][] getInput1() {
		int[][] edges = new int[][] { 
			{ 3 }, 
			{ 1 }, 
			{ 2, 4 }, 
			{ 6 }, 
			{ 4, 7 }, 
			{ 5 }, 
			{ 8 }, 
			{ 9 }, 
			{ 7 }
		};

		return edges;
	}
}
