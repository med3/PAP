import java.io.*;
import java.net.*;

public class Client {
	
	public Connection connection;
	
	public Client()
	{
		System.out.println("Constructor Client");
		connection = new Connection();
	}
	public void sendMessage(String message) {
		connection.sendMessage(message);
	}
	
	public String receiveMessageSynchrone() {
		return connection.receiveMessageSynchrone();
	}
	
	public String receiveMessageAsynchrone() {
		return connection.receiveMessageAsynchrone();
	}
	
    public void init(String serverHostname, int port) throws IOException {

        
        System.out.println ("Attemping to connect to host " +
                serverHostname + " on port " + port);

        try {
        	connection.socket = new Socket(serverHostname, port);
        	connection.start(); //starts the thread to receive messages
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: " + serverHostname);
            System.exit(1);
        }	
	
    }
}
