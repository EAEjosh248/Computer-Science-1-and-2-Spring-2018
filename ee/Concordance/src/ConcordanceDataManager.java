import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.ws.FaultAction;

public class ConcordanceDataManager implements ConcordanceDataManagerInterface {
	private ConcordanceDataStructure ds = new ConcordanceDataStructure(null, 0);

	public ArrayList<String> createConcordanceArray(String input) {
		String[] line;
		String[] word;
		int lineNum = 0,size =0;
		line =  input.replaceAll("[,.!?\"]", "").split("\n");
		
		for(int i =0; i<line.length;i++) {
			size +=line[i].toLowerCase().split(" ").length;
		}
		
		ds = new ConcordanceDataStructure(size);

		for (int i = 0; i < line.length; i++) {
			word = line[i].toLowerCase().split(" ");

			lineNum = i + 1;

			for (int j = 0; j < word.length; j++) {
				if (!word[j].equals("the") && !word[j].equals("and") && word[j].length() >= 3) {
			
					if (word[j].length() >= 3) {

						ds.add(word[j], lineNum);
					}
				}
			}
		}
		ArrayList<String> concordance = ds.showAll();

		return concordance;
	}

	@SuppressWarnings("resource")
	@Override
	public boolean createConcordanceFile(File input, File output) throws FileNotFoundException {
		ArrayList<String> dataFile = new ArrayList<>();
		int size =0;
		String[] word;
		int lineNum = 0;

		if (!input.canRead() || !output.canWrite()) {
			throw new FileNotFoundException();
		}

		Scanner inputFile;
		inputFile = new Scanner(input);

	
		// Read each content, line by line from the .txt file into a String ArrayList
		while (inputFile.hasNext()) {
			dataFile.add(inputFile.nextLine().replaceAll("[,.!?\"]", "").toLowerCase());
		}
		for(int i =0; i<dataFile.size();i++) {
			size +=dataFile.get(i).toLowerCase().split(" ").length;
		}
		

		inputFile.close();
		ds = new ConcordanceDataStructure(dataFile.size());
		for (int i = 0; i < dataFile.size(); i++) {
			word = dataFile.get(i).toLowerCase().split(" ");
			lineNum = ++i;
			for (int j = 0; j < word.length; j++) {
				if (!word[j].equals("the") && !word[j].equals("and") && word[j].length() >= 3) {
					// Strip out all punctuation, except apostrophes that occur in the middle of a
					// word, i.e. let's, we'd, etc."
					

					if (word[j].length() >= 3) {
						ds.add(word[j], lineNum);
					}
				}
			}

			ArrayList<String> concordanceOutputData = ds.showAll();

			PrintWriter outFile = new PrintWriter(output);

			for (int k = 0; k < concordanceOutputData.size(); k++) {
				outFile.print(concordanceOutputData.get(k));
			}
			outFile.close();
			inputFile.close();
		}
		return true;
	}
}
