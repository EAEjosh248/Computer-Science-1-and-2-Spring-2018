import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * {@inheritDoc}
 */
public class Graph implements GraphInterface<Town, Road> {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Set<Town> setOfTowns = new HashSet();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Set<Road> setOfRoads = new HashSet();
	Set<Town> visitedTowns;
	Set<Town> unVisitedTowns;
	ArrayList<String> path = new ArrayList<>();

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		Iterator<Road> iter = setOfRoads.iterator();
		Set<Town> towns = new HashSet();
		towns.add(sourceVertex);
		towns.add(destinationVertex);
		while (iter.hasNext()) {
			Road temp = iter.next();
			if (temp.getTowns().equals(towns))
				return temp;
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
//		sourceVertex.getAdjecentTowns().add((destinationVertex));
//		destinationVertex.getAdjecentTowns().add((sourceVertex));
		sourceVertex.addTowns(destinationVertex);
		destinationVertex.addTowns(sourceVertex);
		Road temp = new Road(sourceVertex, destinationVertex, weight, description);
		setOfRoads.add(temp);
		return temp;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addVertex(Town town) {
		return setOfTowns.add(town);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		Iterator<Road> iter = setOfRoads.iterator();
		Set<Town> towns = new HashSet();
		towns.add(sourceVertex);
		towns.add(destinationVertex);
		while (iter.hasNext()) {
			Road temp = iter.next();
			if (temp.getTowns().equals(towns))
				return true;
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsVertex(Town town) {
		return setOfTowns.contains(town);
	}

	@Override
	public Set<Road> edgeSet() {
		return setOfRoads;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> edgesOfVertex = new HashSet();

		Iterator<Road> iter = setOfRoads.iterator();
		while (iter.hasNext()) {
			Road temp = iter.next();
			if (temp.getTowns().contains(vertex)) {
				edgesOfVertex.add(temp);
			}

		}

		return edgesOfVertex;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
//		(sourceVertex).getAdjecentTowns().remove((destinationVertex));
//		(destinationVertex).getAdjecentTowns().remove((sourceVertex));
		sourceVertex.removeTowns(destinationVertex);
		destinationVertex.removeTowns(sourceVertex);
		Road temp = new Road(sourceVertex, destinationVertex, weight, description);
		return setOfRoads.remove(temp) ? temp : null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean removeVertex(Town town) {
		for(Road r :edgesOf(town)){
			Iterator iter = r.getTowns().iterator();
			Town a = (Town) iter.next();
			Town b = (Town) iter.next();
			removeEdge(a, b, r.getWeight(), r.getName());
		}
		return setOfTowns.remove(town);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Town> vertexSet() {
		return setOfTowns;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		path.clear();
		visitedTowns = new HashSet();
		unVisitedTowns = new HashSet(setOfTowns);
		Town townS,townD;
		townS =townD=null;
		for(Town t : setOfTowns)
		{
			if(t.getName().equals(sourceVertex.getName())) {
				townS =t;
				townS.setAdjecentTowns(t.getAdjecentTowns());
			}
			if(t.getName().equals(destinationVertex.getName())) {
				townD =t;
			}

		}
		townS.setWeight(0);
		visitedTowns.add(townS);
		unVisitedTowns.remove(townS);
		this.dijkstraShortestPath(townS);
		for (Town t : unVisitedTowns) {
			// if(t.getBackpath()!=null)
//			 System.out.println(t.getBackpath());
			// else
//			System.out.println(t.getName().equals(townD.getName()));

		}
		getShortestPath(townS, townD);

		Collections.reverse(path);
		for (Town town : setOfTowns) {
			town.resetPathVarbs();
		}
		return path;
	}

	private void getShortestPath(Town sourceVertex, Town destinationVertex) {
		// Town_1 via Road_1 to Town_2 2 mi"
		try {
		Road tempRoad = getEdge(destinationVertex.getBackpath(), destinationVertex);
		StringBuilder str = new StringBuilder();
		str.append(destinationVertex.getBackpath().getName());
		str.append(" via ");
		str.append(tempRoad.getName());
		str.append(" to ");
		str.append(destinationVertex.getName());
		str.append(" ");
		str.append(tempRoad.getWeight());
		str.append(" mi");

		path.add(str.toString());
		if (!(destinationVertex.getBackpath().equals(sourceVertex))) {
			getShortestPath(sourceVertex, destinationVertex.getBackpath());

		}}catch(NullPointerException e) {

		path.clear();
		path.add("No such path found");
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		Boolean finiding = false;
		while (!unVisitedTowns.isEmpty() && !finiding) {
			finiding = true;
			int shortest = Integer.MAX_VALUE;
			Town closestTown = null;
			for (Town visitedTown : visitedTowns) {

				Set<Town> adjTowns = visitedTown.getAdjecentTowns();

				Set<Town> adjTownsUnVisited = new HashSet<>();
				for (Town town : adjTowns) {
					if (unVisitedTowns.contains(town)) {
						adjTownsUnVisited.add(town);
					}
				}
				for (Town unvisitedTown : adjTownsUnVisited) {
					int totalWeight = getTotalWeight(unvisitedTown, visitedTown, sourceVertex);
					if (totalWeight < shortest) {
						shortest = totalWeight;

						closestTown = unvisitedTown;

						unvisitedTown.setBackpath(visitedTown);
					}
				}

			}
			if (closestTown != null) {
				closestTown.setWeight(shortest);
				visitedTowns.add(closestTown);
				unVisitedTowns.remove(closestTown);
				finiding = false;
			}
		}

	}

	private int getTotalWeight(Town unvisitedTown, Town visitedTown, Town sourceVertex) {
		if (unvisitedTown.equals(sourceVertex))
			return 0;

		return visitedTown.getWeight() + getEdge(visitedTown, unvisitedTown).getWeight();
	}

}
