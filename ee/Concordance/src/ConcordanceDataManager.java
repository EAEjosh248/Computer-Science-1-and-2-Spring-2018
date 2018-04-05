import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ConcordanceDataManager implements ConcordanceDataManagerInterface{
	ConcordanceDataStructure data;

	int lineNumber = 1;
	public ArrayList<String> createConcordanceArray(String input) {
		String[] line;
		String[] word;
		int lineNum = 0,size =0;
		line =  input.replaceAll("[,.!?\"_]", "").split("\n");
		
		for(int i =0; i<line.length;i++) {
			size +=line[i].toLowerCase().split(" ").length;
		}
		
		data = new ConcordanceDataStructure(size);
		System.out.println(line);
		for (int i = 0; i < line.length; i++) {
			word = line[i].toLowerCase().split(" ");

			lineNum = i + 1;

			for (int j = 0; j < word.length; j++) {
				if (!word[j].equals("the") && !word[j].equals("and") && word[j].length() >= 3) {
			
					if (word[j].length() >= 3) {

						data.add(word[j], lineNum);
					}
				}
			}
		}
		ArrayList<String> concordance = data.showAll();

		return concordance;
	}
	
	
	@Override
	public boolean createConcordanceFile(File input, File output) throws FileNotFoundException {
		if(!input.exists())
			throw new FileNotFoundException("File not found.");
		ArrayList<String> data = new ArrayList<String>();
		Scanner in = new Scanner(input);
		String fileIn = "";
		while(in.hasNextLine()) {
			fileIn += in.nextLine() + "\n";
		}
		in.close();
		data = createConcordanceArray(fileIn);
		try {
		FileWriter fw = new FileWriter(output);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter out = new PrintWriter(bw);
		for(int i = 0; i < data.size(); i++) {
			out.print(data.get(i));
		}
		out.flush();
		out.close();
		return true;
		} catch (IOException e) {
			System.out.println("IO Exception occurred");
			e.printStackTrace();
		}
		return true;
	}

}