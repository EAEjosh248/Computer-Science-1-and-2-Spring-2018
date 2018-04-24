import java.util.HashSet;
import java.util.Set;

public class Town implements Comparable<Town> {
	private String name;
	private Set<Town> adjecentTowns;
	private int weight;
	private Town backpath;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Town(String name) {
		this.name = name;
		adjecentTowns = new HashSet();
		weight = Integer.MAX_VALUE;
		backpath = null;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Town getBackpath() {
		return backpath;
	}

	public void setBackpath(Town backpath) {
		this.backpath = backpath;
	}

	public Set<Town> getAdjecentTowns() {
		return adjecentTowns;
	}

	public void setAdjecentTowns(Set<Town> adjecentTowns) {
		this.adjecentTowns = adjecentTowns;
	}
	public void resetPathVarbs() {
		weight = Integer.MAX_VALUE;
		backpath = null;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Town other = (Town) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return compareTo((Town) obj) == 0;
	}

	@Override
	public int compareTo(Town other) {
		return this.name.compareTo(other.getName());
	}

}
