package dijkstras_shortest_path;

public class Vertex2 {

	private int number;
	private int shortPath;

	public Vertex2() {
		
	}
	
	public Vertex2(int number) {
		super();
		this.number = number;
		this.shortPath = -1;
	}


	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public int hashCode() {
		return number;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex2 other = (Vertex2) obj;
		if (number != other.number)
			return false;
		return true;
	}

	public int getShortPath() {
		return shortPath;
	}

	public void setShortPath(int shortPath) {
		this.shortPath = shortPath;
	}
	
}
