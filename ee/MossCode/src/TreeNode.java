public class TreeNode<T>
{
	protected T data;
	protected TreeNode<T> lc;	
	protected TreeNode<T> rc;
	

	public TreeNode (T dataNode)
	{	
		this.data = dataNode;
		this.lc = null;
		this.rc = null;
	}
	
	
	public T getData()
	{
		return data;
	}
	
	public TreeNode (TreeNode<T> node)
	{
		new TreeNode<T>(node);
	}
	
	

	
}