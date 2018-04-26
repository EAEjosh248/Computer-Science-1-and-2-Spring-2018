package network;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Scanner;

class MessageServer {
	
  @SuppressWarnings("resource")
public static void main(String[] args) {
    try {
      ServerSocket server = new ServerSocket(8800);
      System.out.println("Waiting for clients to connect . . .");

      while (true) {
        Socket client = server.accept();
        System.out.println("Client connected.");

        Scanner in = new Scanner(client.getInputStream());
        PrintWriter out = new PrintWriter(client.getOutputStream());
        String whichMessageString = in.nextLine();
        int whichMessage = Integer.parseInt(whichMessageString);
        System.out.println("whichMessage " + whichMessage);
        switch(whichMessage)
        {
          case 1:out.println("Host: You have chosen Option #1 - Chicken");
            out.flush();
            break;
          case 2: out.println("Host: You have chosen Option #2 - Fruit");
            out.flush();
            break;
          case 3 : out.println("Host: You have chosen Option #3 - Coke");
            out.flush();
            break;
          default : out.println("Invalid choice");
            out.flush();
        }
        out.flush();


        out.close();
        client.close();

      }
    }
    catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }
}
