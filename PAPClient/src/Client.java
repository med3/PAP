import java.io.*;
import java.net.*;

public class Client {
	
	public Client() throws IOException
	{
		
	}
    public ClientConnection init(String serverHostname, int port) throws IOException {

        
        System.out.println ("Attemping to connect to host " +
                serverHostname + " on port " + port);

        ClientConnection ClientConnection = new ClientConnection();

        try {
        	ClientConnection.socket = new Socket(serverHostname, port);
        	ClientConnection.out = new PrintWriter(ClientConnection.socket.getOutputStream(), true);
        	ClientConnection.in = new BufferedReader(new InputStreamReader(
        			ClientConnection.socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: " + serverHostname);
            System.exit(1);
        }

        return ClientConnection;
	
	
    }
}
