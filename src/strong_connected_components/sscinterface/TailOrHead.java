package strong_connected_components.sscinterface;

import java.util.List;

import strong_connected_components.Vertex1;

@FunctionalInterface
public interface TailOrHead {

	List<Vertex1> select(Vertex1 v);

}
