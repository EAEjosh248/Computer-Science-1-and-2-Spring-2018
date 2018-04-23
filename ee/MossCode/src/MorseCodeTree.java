import java.util.ArrayList;;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>
{
	private TreeNode<String> root = null;  
	
	private String fetchedLetter; 

	public MorseCodeTree()
	{
		buildTree(); // call the buildTree method to create the tree, and place the letters for the morse code decoder in the correct position. 
	}
	
	

	@Override
	public void addNode(TreeNode<String> root, String code, String letter)
	{	
		switch(code.length()){
		case 1:
			if (code.equals("."))
			{
				root.lc = new TreeNode<String>(letter);
			}
			else
			{
				root.rc = new TreeNode<String>(letter);
			}
			break;
			default:
				if(code.substring(0, 1).equals("."))
				{
					
					addNode(root.lc, code.substring(1), letter);
				}
				
				else
				{
					
					addNode(root.rc, code.substring(1), letter);		
				}
				
		}
	
	   	
	}
	

	@Override
	public MorseCodeTree insert(String code, String letter)
	{
		addNode(root, code, letter);
		
		return this;		
	}


	@Override
	public void buildTree()
	{
		//The root will have a value of "" (empty string)
		root = new TreeNode<String>("");
		
		insert(".", "e");
		insert("-", "t");
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");					
	}

	@Override
	public TreeNode<String> getRoot()
	{
		return this.root;
	}



	@Override
	public void setRoot(TreeNode<String> newNode) {
		
		root = newNode;	
	}


	@Override
	public String fetch(String code)
	{
		// calls the recursive method fetchNode
		String letter = fetchNode(root, code);
		
		return letter;
	}


	
	@Override
	public String fetchNode(TreeNode<String> root, String code)
	{	
		if(code.length() == 1)
	    {
			if (code.equals("."))
			{
				fetchedLetter = root.lc.getData(); 
			}
			
			else
			{
				fetchedLetter =  root.rc.getData(); 
			}
		}
	    else
	    {	
			if(code.substring(0, 1).equals("."))
			{
				
				fetchNode(root.lc, code.substring(1));
			}
			
			else
			{
				
				fetchNode(root.rc, code.substring(1));		
			}		
		}
		
		return fetchedLetter;	
	}


	@Override
	public ArrayList<String> toArrayList()
	{
		ArrayList<String> printTree = new ArrayList<String>();

		LNRoutputTraversal(root, printTree);		

		return printTree;
	}

	

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list)
	{
		if(root != null)
		{
			// recursive method to traverse through the binary tree in LNR (Inorder)
			LNRoutputTraversal(root.lc, list);
			list.add(root.getData());
			LNRoutputTraversal(root.rc, list);
		}
	}
	

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		return null;
	}

	

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		return null;
	}}