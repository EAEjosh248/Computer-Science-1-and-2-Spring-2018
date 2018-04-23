import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Graph<V, E> implements GraphInterface<V, E> {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Set<V> setOfVertex = new HashSet();
	private Set<E> setOfEdges = new HashSet();

	@Override
	public E getEdge(V sourceVertex, V destinationVertex) {
		Iterator<E> iter = setOfEdges.iterator();
		Set<V> towns = new HashSet();
		towns.add(sourceVertex);
		towns.add(destinationVertex);
		while (iter.hasNext()) {
			Road temp = (Road) iter.next();
			if (temp.getTowns().equals(towns))
				return (E) temp;
		}

		return null;
	}

	@Override
	public E addEdge(V sourceVertex, V destinationVertex, int weight, String description) {
		((Town)sourceVertex).getAdjecentTowns().add(((Town)destinationVertex));
		((Town)destinationVertex).getAdjecentTowns().add(((Town)sourceVertex));
		E temp = (E) new Road((Town) sourceVertex, (Town) destinationVertex, weight, description);
		setOfEdges.add(temp);
		return temp;
	}

	@Override
	public boolean addVertex(V v) {
		return setOfVertex.add(v);
	}

	@Override
	public boolean containsEdge(V sourceVertex, V destinationVertex) {
		Iterator<E> iter = setOfEdges.iterator();
		Set<V> towns = new HashSet();
		towns.add(sourceVertex);
		towns.add(destinationVertex);
		while (iter.hasNext()) {
			Road temp = (Road) iter.next();
			if (temp.getTowns().equals(towns))
				return true;
		}

		return false;
	}

	@Override
	public boolean containsVertex(V v) {
		return setOfVertex.contains(v);
	}

	@Override
	public Set<E> edgeSet() {
		return setOfEdges;
	}

	@Override
	public Set<E> edgesOf(V vertex) {
		Set<E> edgesOfVertex = new HashSet();

		Iterator<E> iter = setOfEdges.iterator();
		while (iter.hasNext()) {
			Road temp = (Road) iter.next();
			if(temp.getTowns().contains(vertex)) {
				edgesOfVertex.add((E) temp);
			}

		}

		return edgesOfVertex;
	}

	@Override
	public E removeEdge(V sourceVertex, V destinationVertex, int weight, String description) {
		((Town)sourceVertex).getAdjecentTowns().remove(((Town)destinationVertex));
		((Town)destinationVertex).getAdjecentTowns().remove(((Town)sourceVertex));
		E temp = (E) new Road((Town) sourceVertex, (Town) destinationVertex, weight, description);
		return setOfEdges.remove(temp) ? temp : null;
	}

	@Override
	public boolean removeVertex(V v) {
		return setOfVertex.remove(v);
	}

	@Override
	public Set<V> vertexSet() {
		return setOfVertex;
	}

	@Override
	public ArrayList<String> shortestPath(V sourceVertex, V destinationVertex) {
		this.dijkstraShortestPath(sourceVertex);


		return null;
	}

	@Override
	public void dijkstraShortestPath(V sourceVertex) {
		/*
		 * verticesIncluded[0] = startVertex;  // add the starting vertex to the tree;
numVerticesIncluded = 1;  // one vertex has been added to the tree
for (int i = 0; i < numberOfVertices; i++) // eliminate edges to the starting vertex
{   minPathLengths[i] = noPath
     aCopy[i][ startVertex] = noEdge;
}    
minPathlengths[startVertex] = 0 // set its path length from the starting vertex to 0
while (numVerticiesIncluded < numberOfVertices) //all vertices are not in the tree
{    findMinPath(numberOfVertices, aCopy, verticesIncluded, numVerticesIncluded, 
                         minPathLengths, rowMin, colMin, minWeight, minPath);
     for (int i = 0; i < numberOfVertices; i++) // eliminate edges to the included vertex
     {   aCopy[i][colMin] = noEdge;
     }
     spt[rowMin][colMin] =minWeight; // add min. weighted edge to tree
     spt[colMin][rowMin] =minWeight; 
     minPathlengths[colMin] = minPath;  // add path length to list of min path lengths 
     verticesIncluded[numVerticiesIncluded] = colMin;  // add vertex to included list
     numVerticesIncluded++;  // update the count of vertices included in the tree
 } //end while
  // returns a reference to spt and minPathLengths;

		 * */
		
	}

}
