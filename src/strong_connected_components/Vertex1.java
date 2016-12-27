package strong_connected_components;

import java.util.List;

public class Vertex1 {
	
	private int number;
	// tails of all edges incident to current head
	private List<Vertex1> tails;
	// heads of this vertex in REVERSE!!! graph only
	private List<Vertex1> heads;
	private boolean isVisited;
	private int searchTime;
	private int sccNumber;

	public Vertex1(int number) {
		super();
		this.number = number;
		this.isVisited = false;
		this.searchTime = -1;
		this.sccNumber = -1;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<Vertex1> getTails() {
		return tails;
	}

	public void setTails(List<Vertex1> tails) {
		this.tails = tails;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited() {
		this.isVisited = true;
	}

	public int getSearchTime() {
		return searchTime;
	}

	public void setSearchTime(int searchTime) {
		this.searchTime = searchTime;
	}

	public int getSccNumber() {
		return sccNumber;
	}

	public void setSccNumber(int sccNumber) {
		this.sccNumber = sccNumber;
	}

	public List<Vertex1> getHeads() {
		return heads;
	}

	public void setHeads(List<Vertex1> heads) {
		this.heads = heads;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

}
