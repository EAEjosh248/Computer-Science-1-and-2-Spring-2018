import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("unchecked")
public class TownGraphManager implements TownGraphManagerInterface {
	@SuppressWarnings("rawtypes")
	private Graph map = new Graph<Town, Road>();
	private ArrayList<String> roads = new ArrayList<String>();
	private ArrayList<String> towns = new ArrayList<String>();

	@Override
	public boolean addRoad(String sourceTown, String desntinationTown, int weight, String roadName) {
		Town townS = new Town(sourceTown);
		Town townD = new Town(desntinationTown);

		if (map.containsVertex(townS) && map.containsVertex(townD)) {
			if (map.containsEdge(townS, townD) == false) {
				map.addEdge(townS, townD, 1, roadName);

				Road road = (Road) map.addEdge(townS, townD, 1, roadName);

				roads.add(road.getName());

				return true;
			}
		}
		return false;
	}

	@Override
	public String getRoad(String sourceTown, String desntinationTown) {

		Town townS = new Town(sourceTown);
		Town townD = new Town(desntinationTown);

		if (map.containsEdge(townS, townD)) {
			Road roadName = (Road) map.getEdge(townS, townD);

			return roadName.getName();
		}
		return null;
	}

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

	@Override
	public boolean containsTown(String townName) {
		Town town = new Town(townName);

		return (map.containsVertex(town));

	}

	@Override
	public boolean containsRoadConnection(String sourceTown, String desntinationTown) {
		Town townS = new Town(sourceTown);
		Town townD = new Town(desntinationTown);

		return (map.containsEdge(townS, townD));
	}

	@Override
	public ArrayList<String> allRoads() {

		ArrayList<String> sortedRoads = new ArrayList<String>();

		sortedRoads = roads;

		Collections.sort(roads);

		return sortedRoads;
	}

	@Override
	public boolean deleteRoadConnection(String sourceTown, String desntinationTown, String roadName) {
		Town townS = new Town(sourceTown);
		Town townD = new Town(desntinationTown);

		if (map.containsEdge(townS, townD) == true) {
			map.removeEdge(townS, townD, 1, roadName);

			return true;
		}

		return false;

	}

	@Override
	public boolean deleteTown(String townName) {
		Town actor = new Town(townName);

		if (map.containsVertex(actor)) {
			map.removeVertex(actor);
			towns.remove(townName);
			return true;
		}
		return false;

	}

	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> sortedTownNames = new ArrayList<String>();
		sortedTownNames = towns;

		Collections.sort(sortedTownNames);

		return sortedTownNames;
	}

	@Override
	public ArrayList<String> getPath(String sourceTown, String desntinationTown) {
		Town townS = new Town(sourceTown);
		Town townD = new Town(desntinationTown);

		if (map.containsEdge(townS, townD)) {
			return map.shortestPath(townS, townD);
		}

		return null;

	}

}
