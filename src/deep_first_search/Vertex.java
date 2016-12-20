package deep_first_search;

public class Vertex {

	private int number;
	// tails of all edges incident to current head
	private Vertex[] tails;
	private boolean isVisited;
	private int topologicalNumber;
	
	public Vertex(int number) {
		super();
		this.number = number;
		this.isVisited = false;
		this.topologicalNumber = -1;
	}

	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}

	public Vertex[] getTails() {
		return tails;
	}

	public void setTails(Vertex[] tails) {
		this.tails = tails;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited() {
		this.isVisited = true;
	}

	public int getTopologicalNumber() {
		return topologicalNumber;
	}

	public void setTopologicalNumber(int topologicalNumber) {
		this.topologicalNumber = topologicalNumber;
	}

}
