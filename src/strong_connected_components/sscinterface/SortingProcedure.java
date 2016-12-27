package strong_connected_components.sscinterface;

import java.util.List;

import strong_connected_components.Graph1;
import strong_connected_components.Vertex1;

@FunctionalInterface
public interface SortingProcedure {

	List<Vertex1> sort(Graph1 g);
	
}
