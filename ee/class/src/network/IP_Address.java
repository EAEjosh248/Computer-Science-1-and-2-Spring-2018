package network;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class IP_Address {

	public static void main(String[] args) {
		try {
			System.out.println("Local IP: " +
					InetAddress.getLocalHost());
					
		}
		catch (UnknownHostException e) {
			System.out.println("Local address unknown");
		}

	}

}
