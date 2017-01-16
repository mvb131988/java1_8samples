package dijkstras_shortest_path_with_heap;

public class Edge3 {

	private Vertex3 head;
	private Vertex3 tail;
	private int weight;

	public Edge3(Vertex3 head, Vertex3 tail, int weight) {
		super();
		this.head = head;
		this.tail = tail;
		this.weight = weight;
	}

	public Vertex3 getHead() {
		return head;
	}

	public void setHead(Vertex3 head) {
		this.head = head;
	}

	public Vertex3 getTail() {
		return tail;
	}

	public void setTail(Vertex3 tail) {
		this.tail = tail;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
