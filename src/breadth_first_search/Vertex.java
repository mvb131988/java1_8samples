package breadth_first_search;

public class Vertex {

	private int id;
	private int layer;
	private int timesVisited;
	
	public Vertex(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLayer() {
		return layer;
	}

	public void setLayer(int layer) {
		this.layer = layer;
	}

	public int getTimesVisited() {
		return timesVisited;
	}

	public void setTimesVisited(int timesVisited) {
		this.timesVisited = timesVisited;
	}
	
	public void incrementTimesVisited() {
		this.timesVisited ++;
	}
}
