package network;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
   This program tests the bank server.
*/
public class BankClient
{
   public static void main(String[] args) throws IOException
   {
      final int SBAP_PORT = 8888;
      try (Socket s = new Socket("localhost", SBAP_PORT))
      {         
         InputStream instream = s.getInputStream();
         OutputStream outstream = s.getOutputStream();
         Scanner in = new Scanner(instream);
         PrintWriter out = new PrintWriter(outstream); 
      
         String command = "BALANCE 3";
         System.out.println(command);
         out.print(command + "\n");
         out.flush();
         String response = in.nextLine();
         System.out.println("Host: " + response + "\n");
         
         command = "DEPOSIT 3 2000";
         System.out.println(command);
         out.print(command + "\n");
         out.flush();
         response = in.nextLine();
         System.out.println("Host: " + response + "\n");
      
         command = "WITHDRAW 3 700";
         System.out.println(command);
         out.print(command + "\n");
         out.flush();
         response = in.nextLine();
         System.out.println("Host: " + response + "\n");
      
         command = "BALANCE 3";
         System.out.println(command);
         out.print(command + "\n");
         out.flush();
         response = in.nextLine();
         System.out.println("Host: " + response + "\n");
         
         command = "QUIT";
         System.out.println(command);
         out.print(command + "\n");
         out.flush();
      }
   }
}





