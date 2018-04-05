import java.util.Iterator;
import java.util.LinkedList;

public class ConcordanceDataElement implements Comparable<ConcordanceDataElement> {
	private String word;
	private LinkedList<Integer> pageNumber;


	ConcordanceDataElement(String word) {
		this.word = word;
		pageNumber = new LinkedList<Integer> ();
	}

	@Override
	public int compareTo(ConcordanceDataElement o) {
		return this.word.compareToIgnoreCase(o.getWord());
	}

	public void addPage(int lineNum) {
		if(!pageNumber.contains(lineNum)){
			pageNumber.add(lineNum);
		}


	}

	LinkedList<Integer> getList() {
		return (LinkedList<Integer>) pageNumber.clone();

	}

	public String getWord() {
		return word;

	}

	public int hashCode() {
		return word.hashCode();
	}

	public String toString() {
		String temp = ": ";
		Iterator iter = pageNumber.iterator();
		temp += iter.next();
		while (iter.hasNext())
			temp += ", " + iter.next();
		return word + temp +"\n";

	}
}
