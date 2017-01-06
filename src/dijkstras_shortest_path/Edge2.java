package dijkstras_shortest_path;

public class Edge2 {

	private int head;
	private int tail;
	private int weight;

	public Edge2(int head, int tail, int weight) {
		super();
		this.head = head;
		this.tail = tail;
		this.weight = weight;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Edge2) {
			Edge2 ed = (Edge2) obj;
			return this.head == ed.getHead() && this.tail == ed.getTail();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return head + tail;
	}

	public int getHead() {
		return head;
	}

	public void setHead(int head) {
		this.head = head;
	}

	public int getTail() {
		return tail;
	}

	public void setTail(int tail) {
		this.tail = tail;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
