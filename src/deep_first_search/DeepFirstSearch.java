package deep_first_search;

import java.util.Stack;

public class DeepFirstSearch {

	private int currentLabel;
	private Stack<Vertex> topologicalOrder = new Stack<Vertex>();
	private int numberOfDfsExecutions = 0;
	
	public void topologicalSort(Graph g, int startVertexNumber) {
		currentLabel = g.size();
		Vertex v = g.getVertex(startVertexNumber);
		sort(v);
		
		for(Vertex v1: g.getAll()) {
			if(!v1.isVisited()) {
				sort(v1);
			}
		}
		
		System.out.println("Number of DFS executions: " + numberOfDfsExecutions);
		
		printStack(topologicalOrder);
	}

	public void sort(Vertex h) {
		sortInternally(h, topologicalOrder);
		numberOfDfsExecutions++;
	}

	private void sortInternally(Vertex s, Stack<Vertex> stack) {
		// if this isn't a sink vertex
		if (s.getTails().length != 0) {
			for (Vertex t : s.getTails()) {
				if (!t.isVisited()) {
					sortInternally(t, stack);
				}
			}
		}

		s.setVisited();
		s.setTopologicalNumber(currentLabel--);
		stack.push(s);
	}

	private void printStack(Stack<Vertex> stack) {
		// stack.forEach(v -> System.out.print( v.getNumber() + " -> "));
		System.out.print("Topological order: ");
		while (!stack.isEmpty()) {
			Vertex v = stack.pop();
			System.out.print(v.getNumber() + "(" + v.getTopologicalNumber() + ") -> ");
		}
		System.out.println("");
	}

}
