package Hash;


public class MainLqHashed {
    public static void main(String[] args)
    {  
    	LqHashed<Listing> dataBase = new LqHashed<Listing>(100);
        Listing b, t;
        Listing bill = new Listing("Bill", "1st Avenue", "999 9999");
        Listing tom = new Listing("Tom", "2nd Avenue", "456 8978");
        Listing newBill = new Listing("William", "99th Street", "123 4567");
        
    // inserts
       dataBase.insert(bill);
       dataBase.insert(tom);
       
     // fetches
        b = dataBase.fetch("Bill");
        t = dataBase.fetch("Tom");
        System.out.println(b);
        System.out.println(t);
        
     // update of Bill's address
        dataBase.update("Bill", newBill);
        b = dataBase.fetch("William");  //fetches
        System.out.println(b);
        
     // demonstration of encapsulation. Client can not change the contents of the node
        newBill.setAddress("18 Park Avenue");
        b = dataBase.fetch("William");
        System.out.println(b);
        
     // delete operation
       dataBase.delete("William");
       b = dataBase.fetch("William");
       System.out.println(b);    }
    }

