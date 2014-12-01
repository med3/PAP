import java.net.*; 
import java.util.*;
import java.io.*; 

public class Server extends Thread
{ 
 int portNumber;
 
 List<Connection> listOfConnections;
 HashMap<SocketAddress, Connection> connectionsHashMap;

 public Server(int portNumber){
	 this.portNumber = portNumber;
	 listOfConnections = new ArrayList<Connection>();
	 connectionsHashMap = new HashMap<SocketAddress, Connection>();
	 start();
 }
 
 public void sendMessage(String message, SocketAddress address) {
	 connectionsHashMap.get(address).out.println(message);
 }
 
 public void sendMessage(String message) {
	 for (Connection c : listOfConnections) {
			c.sendMessage(message);
		}
 }
 public String receiveMessageAsynchrone() {
	 for (Connection c : listOfConnections) {
		String message = c.receiveMessageAsynchrone();
			if( message!=null)
				return message;
	 }
	 return null;
 }
 public String receiveMessageAsynchrone(SocketAddress address) {
	 return connectionsHashMap.get(address).receiveMessageAsynchrone();
 }
 
 public String receiveMessageSynchrone(SocketAddress address) {
	 return connectionsHashMap.get(address).receiveMessageSynchrone();
 }
 
 public String receiveMessageSynchrone() { //Does not work
	 for (Connection c : listOfConnections) {
			String message = c.receiveMessageSynchrone();
				if( message!=null)
					return message;
	 }
	return null;
 }
 
 public void run()
   { 
    ServerSocket serverSocket = null; 

    try { 
         serverSocket = new ServerSocket(portNumber); 
         System.out.println ("Server Socket Created");
         try {
              while (true)
                 {
                  System.out.println ("Waiting for Connection");
                  Connection connection = new Connection();
                  connection.socket = serverSocket.accept();
                  connection.socketAddress = connection.socket.getRemoteSocketAddress();
                  connectionsHashMap.put(connection.socketAddress, connection);
                  //System.out.println(connection.socketAddress);
                  connection.start();
                  listOfConnections.add(connection);
                  }
             } 
         catch (IOException e) 
             { 
              System.err.println("Accept failed."); 
              System.exit(1); 
             } 
        } 
    catch (IOException e) 
        { 
         System.err.println("Could not listen on port: " + portNumber); 
         System.exit(1); 
        } 
    finally
        {
         try {
              serverSocket.close(); 
             }
         catch (IOException e)
             { 
              System.err.println("Could not close port: " + portNumber); 
              System.exit(1); 
             } 
        }
   }
} 