package network;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MessageClient {
   public static void main(String args[]) {
       try {
         Scanner scan = new Scanner(System.in);
         Socket client = new Socket("localhost", 8800);
         InputStream instream = client.getInputStream();
         OutputStream outstream = client.getOutputStream();
         Scanner in = new Scanner(instream);
         PrintWriter out = new PrintWriter(outstream);
         System.out.println("1.  First\n2.  Second\n3.  Third\nWhich option? ");
         int option = scan.nextInt();
         out.print("" + option+ "\n");
         out.flush();
         String response = in.nextLine();
         System.out.println(response);
         in.close();
         client.close();
       }
       catch (UnknownHostException e) {
         System.err.println("No such host");
       }
       catch (IOException e) {
         System.err.println(e.getMessage());
       }
   }
}
