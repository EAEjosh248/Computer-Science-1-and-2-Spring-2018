package BTS;

import java.util.*;

public class BST <T extends Comparable<T>> 
{
	
	
   public static void main(String[] args)
   {
	    BST<Student> bst = new BST<Student>();
	      bst = new BST<Student>(new StudentComparator());
	   System.out.println("Welcome to student info manager for MC");
	   while(true) {
		   
		   
		   Student[] a = {
		    		  new Student("bob lee","1",15),
		    		  new Student("eric lee","2",1),
		    		  new Student("berry lee","3",1),
		    		  new Student("raj lee","2",1),
		    		  new Student("alpha lee","2",1),
		    		  new Student("bam lee","2",1),
		    		  new Student("i dont care lee","2",1)};
		      for(Student n : a) 
			   bst.insert(n);

		      
		      int input = 0;

		   Scanner sc = new Scanner(System.in);

		   System.out.println("Please enter: "
		   		+ "\n 1. insert a new student "
		   		+ "\n 2. to fetch a student's information "
		   		+ "\n 3. delete a student "
		   		+ "\n 4. update a student's information "
		   		+ "\n 5. to print students' information "
		   		+ "\n 6. quit");
		   Student temp =null;
		   input = sc.nextInt();
		   
		   switch(input) {
		   case 1: 
			   // user input
			   System.out.println("What is the student's name you want to add?");
			   sc.nextLine();
			   String nameI = sc.nextLine();
			   System.out.println("What is the student's id you want to add?");
			   String idI = sc.nextLine();
			   System.out.println("What is the student's gpa you want to add?");
			   double gpaI = sc.nextDouble();
			   
			   // inserting to the bst

			   temp =new Student(nameI,idI,gpaI);

			      bst.insert(temp);

			   break;
		   case 2:
			   
			   System.out.println("What is the student's name you want to fetch?");
			   sc.nextLine();

			   String nameF = sc.nextLine();
			  temp =bst.fetch(new Student(nameF,"",0));
			   System.out.println(temp.toString());
			   break;
		   case 3:
			   
			   System.out.println("What is the student's name you want to Delete?");
			   sc.nextLine();

			   String nameD = sc.nextLine();
			   temp  = new Student(nameD,"",0);
			   bst.delete(temp);
			   
			   break;
		   case 4:
			   sc.nextLine();

			   System.out.println("What is the student's name you want to update?");
			   String nameU = sc.nextLine();
			   if(bst.search(new Student(nameU,"",0))) {
				   System.out.println("What is the student's id you want to update?");
				   String idU = sc.nextLine();
				   System.out.println("What is the student's gpa you want to update?");
				   double gpaU = sc.nextDouble();
				   temp = new Student(nameU,"",0);
				   bst.delete(temp);
				   temp = new Student(nameU,idU,gpaU);
				      bst.insert(temp);

			   }else {
				   
				   System.out.println("no such student found");
			   }
			   
			   break;
		   case 5: 
			      bst.inOrderTraversal();
			      break;
		   case 6: System.exit(0);break;
		   default:
			   System.out.println("I did not understand the input try again.");
			   
		 
		   }
		   
	   }

   }


   
   private WrapperNode<T> root;
   private Comparator<T> comparator;

   public BST()
   {
      root = null;
      comparator = null;
   }

   public BST(Comparator<T> comp)
   {
      root = null;
      comparator = comp;
   }

   private int compare(T x, T y)
   {
      if(comparator == null) return x.compareTo(y);
      else
      return comparator.compare(x,y);
   }

   public void insert(T data)
   {
      root = insert(root, data);
   }
   private WrapperNode<T> insert(WrapperNode<T> p, T toInsert)
   {
      if (p == null)
         return new WrapperNode<T>(toInsert);

      if (compare(toInsert, p.data) == 0)
      	return p;

      if (compare(toInsert, p.data) < 0)
         p.left = insert(p.left, toInsert);
      else
         p.right = insert(p.right, toInsert);

      return p;
   }

   public boolean search(T toSearch)
   {
      return search(root, toSearch);
   }
   private boolean search(WrapperNode<T> p, T toSearch)
   {
      if (p == null)
         return false;
      else
      if (compare(toSearch, p.data) == 0)
      	return true;
      else
      if (compare(toSearch, p.data) < 0)
         return search(p.left, toSearch);
      else
         return search(p.right, toSearch);
   }
  
      public boolean update(T toSearch,T toUpdate)
      {
         return update(root, toSearch,toUpdate);
      }
      private boolean update(WrapperNode<T> p, T toSearch,T toUpdate)
      {
         if (p == null)
            return false;
         else
         if (compare(toSearch, p.data) == 0) {
        	 p.data = toUpdate;
         	return true;
         	}
         else
         if (compare(toSearch, p.data) < 0)
            return update(p.left, toSearch,toUpdate);
         else
            return update(p.right, toSearch,toUpdate);
      }
      public T fetch(T toSearch)
      {
         return fetch(root, toSearch);
      }
      private T fetch(WrapperNode<T> p, T toSearch)
      {
         if (p == null)
            return null;
         else
         if (compare(toSearch, p.data) == 0) {
        	return  p.data ;
         	}
         else
         if (compare(toSearch, p.data) < 0)
            return fetch(p.left, toSearch);
         else
            return fetch(p.right, toSearch);
      }


   public void delete(T toDelete)
   {
      root = delete(root, toDelete);
   }
   private WrapperNode<T> delete(WrapperNode<T> p, T toDelete)
   {
      if (p == null) { 
    	  System.out.println("No such student found");
//    	  throw new RuntimeException("cannot delete.");
    	  }
      else
      if (compare(toDelete, p.data) < 0)
      p.left = delete (p.left, toDelete);
      else
      if (compare(toDelete, p.data)  > 0)
      p.right = delete (p.right, toDelete);
      else
      {
         if (p.left == null) return p.right;
         else
         if (p.right == null) return p.left;
         else
         {
         // get data from the rightmost node in the left subtree
            p.data = retrieveData(p.left);
         // delete the rightmost node in the left subtree
            p.left =  delete(p.left, p.data) ;
         }
      }
      return p;
   }
   private T retrieveData(WrapperNode<T> p)
   {
      while (p.right != null) p = p.right;

      return p.data;
   }


   public void inOrderTraversal()
   {
	   System.out.println("ID||Name||Gpa");

      inOrderHelper(root);
   }
   private void inOrderHelper(WrapperNode r)
   {
      if (r != null)
      {
         inOrderHelper(r.left);
         System.out.println(r+", ");
         inOrderHelper(r.right);
      }
   }

   public class WrapperNode<T>
   {
      private T data;
      private WrapperNode<T> left, right;

      public WrapperNode(T data, WrapperNode<T> l, WrapperNode<T> r)
      {
         left = l; right = r;
         this.data = data;
      }

      public WrapperNode(T data)
      {
         this(data, null, null);
      }

      public String toString()
      {
         return data.toString();
      }
   }

}//end of BST




class StudentComparator implements Comparator<Student>
{
   public int compare(Student x, Student y)
   {
        return x.getName().compareTo(y.getName());
   }
   
}