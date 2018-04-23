import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
private static MorseCodeTree t = new MorseCodeTree();
	
	
	public MorseCodeConverter()
	{
		
	}

		
	
	public static String convertToEnglish(String code)
	{
		String output = "";
		String[] word; // will hold each singular word from
		String[] letter; // will hold each singular word from
		
		
		word = code.split(" / ");

		for(int i = 0; i < word.length; i++)
		{	
			letter = word[i].split(" ");
			
			for(int j = 0; j < letter.length; j++)
			{
		
				output += t.fetch(letter[j]);	
			}
			
			output += " ";
		}	
		
		output = output.trim();
		
		return output;
	}
	
	
	
	
	public static String convertToEnglish(File codeFile) throws java.io.FileNotFoundException
	{
		String output = "";
		ArrayList<String> line = new ArrayList<String>();
		String[] words; 
		String[] letters; 
		
		Scanner inputFile;
		inputFile = new Scanner(codeFile);
		
		while (inputFile.hasNext())
		{	
			line.add(inputFile.nextLine());
		}
			
		inputFile.close();
		
		for(int i = 0; i < line.size(); i++)
		{

			// split each word in the current line into a new array. 
			
			output+= convertToEnglish(line.get(i));

		}
	
		output = output.trim();
		
		return output;
	}

	
	public static String printTree()
	{
		ArrayList<String> treeData = new ArrayList<String>();
		
		treeData = t.toArrayList();
		
		String print = "";
		
		for(int i = 0; i < treeData.size(); i ++)
		{
			print += treeData.get(i) + " ";	
		}
		
		return print;
	}

}
