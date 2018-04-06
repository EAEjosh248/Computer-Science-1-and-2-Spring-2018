
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ConcordanceDataStructure implements ConcordanceDataStructureInterface {
	private LinkedList<ConcordanceDataElement>[] table;
	private int TableSize;
	private final double loadingFactor = 1.5;

	public ConcordanceDataStructure(int expextedSize) {
		TableSize = fourKPlus3(expextedSize, (int) ((1.0 / loadingFactor - 1) * 100.0));
		table = new LinkedList[TableSize];
	}

	public ConcordanceDataStructure(String test, int expextedSize) {
		TableSize = expextedSize;
		table = new LinkedList[TableSize];

	}

	@Override
	public int getTableSize() {
		return TableSize;
	}

	@Override
	public ArrayList<String> getWords(int index) {
		ArrayList<String> temp = new ArrayList<String>();
		LinkedList<ConcordanceDataElement> list = table[index];
		for (int i = 0; i < list.size(); i++) {
			temp.add(list.get(i).getWord());
		}
		return temp;
	}

	@Override
	public ArrayList<LinkedList<Integer>> getPageNumbers(int index) {

		ArrayList<LinkedList<Integer>> temp = new ArrayList<LinkedList<Integer>>();
		LinkedList<ConcordanceDataElement> list = table[index];
		for (int i = 0; i < list.size(); i++) {
			temp.add(list.get(i).getList());
		}
		return temp;
	}

	@Override
	public void add(String word, int lineNum) {

		int index;
		boolean added = false;
		ConcordanceDataElement element = new ConcordanceDataElement(word.toLowerCase());
		index = Math.abs(element.hashCode() % TableSize);
		if (table[index] != null) {
			for (int i = 0; i < table[index].size(); i++) {
				if (table[index].get(i).compareTo(element) == 0) {
					table[index].get(i).addPage(lineNum);
					added = true;
				}
			}
		} else {
			LinkedList<ConcordanceDataElement> listAdd = new LinkedList<ConcordanceDataElement>();
			listAdd.add(element);
			table[index] = listAdd;
			table[index].getFirst().addPage(lineNum);
			added = true;
		}
		if (added == false) {
			table[index].add(element);
			table[index].getLast().addPage(lineNum);
		}
	}

	@Override
	public ArrayList<String> showAll() {

		ArrayList<String> string = new ArrayList<String>();
		ArrayList<ConcordanceDataElement> listCombined = new ArrayList<ConcordanceDataElement>();
		ConcordanceDataElement copy;
		int index = 0;
		for(int i = 0; i < TableSize; i++) {
			if(table[i] != null)
			for(int j = 0; j < table[i].size(); j++) {
				copy = table[i].get(j);
				listCombined.add(copy);
				index++;
			}
			
			
		}
		
		ConcordanceDataElement smallest;
		ConcordanceDataElement temp;
		int smallestIndex;
		for(int i = 0; i < listCombined.size(); i++) {
			smallestIndex = i;
			smallest = listCombined.get(i);
			for(int j = i; j < listCombined.size(); j++) {
				if(listCombined.get(j).compareTo(smallest) < 0) {
					smallest = listCombined.get(j);
					smallestIndex = j;
				}
			}
			temp = listCombined.get(i);
			listCombined.remove(i);
			if(smallestIndex != 0)
			listCombined.add(i, listCombined.get(smallestIndex - 1));
			else
				listCombined.add(i, listCombined.get(smallestIndex));
			listCombined.remove(smallestIndex);
			listCombined.add(smallestIndex, temp);
		}
		
		for(int i = 0; i < listCombined.size(); i++) {
			string.add(listCombined.get(i).toString());
		}

		return string;
	}
		
//		ArrayList<String> temp = new ArrayList<String>();
//
//		for (int i = 0; i < TableSize; i++) {
//			if (table[i] != null)
//				for (int j = 0; j < table[i].size(); j++) {
//
//					temp.add(table[i].get(j).toString());
//				}
//
//		}
//
//		Collections.sort(temp, new Comparator<String>() {
//			@Override
//			public int compare(String s1, String s2) {
//				return s1.compareToIgnoreCase(s2);
//			}
//		});

//		return temp;}
	
	

	

	public static int fourKPlus3(int n, int pct) // from Figure 5.16
	{
		boolean fkp3 = false;
		boolean aPrime = false;
		int prime, highDivisor, d;
		double pctd = pct;
		prime = (int) (n * (1.0 + (pctd / 100.0))); // guess the prime pct percent larger than n
		if (prime % 2 == 0) // if even make the prime guess odd
			prime = prime + 1;
		while (fkp3 == false) // not a 4k+3 prime
		{
			while (aPrime == false) // not a prime
			{
				highDivisor = (int) (Math.sqrt(prime) + 0.5);
				for (d = highDivisor; d > 1; d--) {
					if (prime % d == 0)
						break;
				}
				if (d != 1) // prime not found
					prime = prime + 2;
				else
					aPrime = true;
			} // end of the prime search loop
			if ((prime - 3) % 4 == 0)
				fkp3 = true;
			else {
				prime = prime + 2;
				aPrime = false;
			}
		} // end of 4k+3 prime search loop
		return prime;
	}

}
