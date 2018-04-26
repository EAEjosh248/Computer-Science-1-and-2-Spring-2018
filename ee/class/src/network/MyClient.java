package network;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyClient {
   public static void main(String args[]) {
       try {
         Scanner scan = new Scanner(System.in);
         
         System.out.println("Which port? ");
         
         int port = scan.nextInt();
         
         // Socket client = new Socket("localhost", port);
         
         InetAddress addr = InetAddress.getByName("172.26.198.242");
         Socket client = new Socket(addr, port);
         
         Scanner in = new Scanner(client.getInputStream());
         
         System.out.println("Received: " + in.nextLine());
         
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
