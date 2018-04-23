import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Road implements Comparable<Road> {

	private String name;
	private int weight;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Set<Town> Towns = new HashSet();

	public Road(Town sourceTown, Town desntinationTown, int weight, String name) {
		this.name = name;
		this.weight = weight;
		Towns.add(sourceTown);
		Towns.add(desntinationTown);
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Set<Town> getTowns() {
		return Towns;
	}

	public void setTowns(Set<Town> towns) {
		Towns = towns;
	}

	@Override
	public int compareTo(Road other) {
		return this.getWeight() - other.getWeight();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Towns == null) ? 0 : Towns.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Road other = (Road) obj;
		if (Towns == null) {
			if (other.Towns != null)
				return false;
		} else if (!Towns.equals(other.Towns))
			return false;
		return true;
	}

	@Override
	public String toString() {
		Iterator<Town> iter = Towns.iterator();
		return name + ";" + weight + ";" + iter.next().getName() + iter.next().getName();

	}

}
