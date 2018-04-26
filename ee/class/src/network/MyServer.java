package network;
import java.io.*;
import java.net.*;
import java.util.Date;

class MyServer {
  public static void main(String[] args) {
    try {
      ServerSocket listen = new ServerSocket(0);
      
      System.out.println("Waiting for clients to connect . . ." + listen.getLocalPort());

      while (true) {
        Socket client = listen.accept();
        System.out.println("Client connected.");

        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        
        out.println("Thai - Current local time is: " + new Date());

        out.close();
        client.close();

      }
    }
    catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }
}
