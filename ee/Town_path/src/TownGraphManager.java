import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/**
 * {@inheritDoc}
 */
public class TownGraphManager implements TownGraphManagerInterface {
	private Graph map = new Graph();
	private ArrayList<String> roads = new ArrayList<String>();
	private ArrayList<String> towns = new ArrayList<String>();

	public Town getTownFromMap(String name) {
		Set <Town> towns = map.vertexSet();
		for(Town t : towns) {
			if(t.getName().equals(name))
				return t;
		}
		return null;
	}
	
	public int getRoadFromMapWeight(String name,Town a, Town b) {
		Set <Road> roads = map.edgeSet();
		for(Road t : roads) {
			Set<Town> towns =new HashSet<Town>();
			towns.add(a);
			towns.add(b);
			if(t.getName().equals(name))
				if(t.getTowns().equals(towns))
				return t.getWeight();
		}
		return Integer.MAX_VALUE;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addRoad(String sourceTown, String desntinationTown, int weight, String roadName) {
		Town townS =getTownFromMap(sourceTown);
		Town townD = getTownFromMap(desntinationTown);

		if (map.containsVertex(townS) && map.containsVertex(townD)) {
			if (!map.containsEdge(townS, townD) ) {
				map.addEdge(townS, townD, weight, roadName);
				Road road = (Road) map.addEdge(townS, townD, weight, roadName);

				roads.add(road.getName());

				return true;
			}
		}
		return false;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getRoad(String sourceTown, String desntinationTown) {

		Town townS = getTownFromMap(sourceTown);
		Town townD = getTownFromMap(desntinationTown);

		if (map.containsEdge(townS, townD)) {
			Road roadName = (Road) map.getEdge(townS, townD);

			return roadName.getName();
		}
		return null;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addTown(String townName) {
		Town newTown = new Town(townName);

		if (!map.containsVertex(newTown)) {
			map.addVertex(newTown);

			towns.add(townName);

			return true;
		}
		return false;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsTown(String townName) {
		Town town =getTownFromMap(townName);

		return (map.containsVertex(town));

	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsRoadConnection(String sourceTown, String desntinationTown) {
		Town townS = new Town(sourceTown);
		Town townD = new Town(desntinationTown);

		return (map.containsEdge(townS, townD));
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArrayList<String> allRoads() {

		ArrayList<String> sortedRoads = new ArrayList<String>();

		sortedRoads = roads;

		Collections.sort(roads);

		return sortedRoads;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteRoadConnection(String sourceTown, String desntinationTown, String roadName) {
		Town townS =getTownFromMap(sourceTown);
		Town townD = getTownFromMap(desntinationTown);

		if (map.containsEdge(townS, townD) == true) {
			map.removeEdge(townS, townD, getRoadFromMapWeight(roadName, townS, townD), roadName);
			roads.remove(roadName);
			return true;
		}

		return false;

	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteTown(String townName) {
		Town town =getTownFromMap(townName);

		if (map.containsVertex(town	)) {
			map.removeVertex(town);
			towns.remove(townName);
			return true;
		}
		return false;

	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> sortedTownNames = new ArrayList<String>();
		sortedTownNames = towns;

		Collections.sort(sortedTownNames);

		return sortedTownNames;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArrayList<String> getPath(String sourceTown, String desntinationTown) {
		Town townS = getTownFromMap(sourceTown);
		Town townD = getTownFromMap(desntinationTown);
		if(map.containsVertex(townD) && map.containsVertex(townS))
			return map.shortestPath(townS, townD);
		return null;

	

	}

}
