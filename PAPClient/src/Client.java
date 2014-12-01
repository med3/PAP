import java.io.*;
import java.net.*;

public class Client {
	
	public Client() throws IOException
	{
		
	}
    public Connection init(String serverHostname, int port) throws IOException {

        
        System.out.println ("Attemping to connect to host " +
                serverHostname + " on port " + port);

        Connection connection = new Connection();

        try {
        	connection.socket = new Socket(serverHostname, port);
        	connection.out = new PrintWriter(connection.socket.getOutputStream(), true);
        	connection.in = new BufferedReader(new InputStreamReader(
        			connection.socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: " + serverHostname);
            System.exit(1);
        }

        return connection;
	
	
    }
}
