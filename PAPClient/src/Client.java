import java.io.*;
import java.net.*;

public class Client {
	
	public Client() throws IOException
	{
		
	}
    public void init(String serverHostname, int port) throws IOException {

        
        System.out.println ("Attemping to connect to host " +
                serverHostname + " on port " + port);

        ClientConnection clientConnection = new ClientConnection();

        try {
        	clientConnection.socket = new Socket(serverHostname, port);
        	clientConnection.out = new PrintWriter(clientConnection.socket.getOutputStream(), true);
        	clientConnection.in = new BufferedReader(new InputStreamReader(
        			clientConnection.socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: " + serverHostname);
            System.exit(1);
        }

	BufferedReader stdIn = new BufferedReader(
                                   new InputStreamReader(System.in));
	String userInput;

        System.out.println ("Type Message (\"Bye.\" to quit)");
	while ((userInput = stdIn.readLine()) != null) 
           {
		clientConnection.out.println(userInput);

            // end loop
            if (userInput.equals("Bye."))
                break;

	    System.out.println("echo: " + clientConnection.in.readLine());
	   }

	clientConnection.out.close();
	clientConnection.in.close();
	stdIn.close();
	clientConnection.socket.close();
    }
}
