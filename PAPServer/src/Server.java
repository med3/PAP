import java.net.*; 
import java.util.ArrayList;
import java.util.List;
import java.io.*; 

public class Server extends Thread
{ 
 protected Socket clientSocket;
 List<Connection> listOfConnections;

 public Server(){
	 listOfConnections = new ArrayList<Connection>();
 }
 
 public void sendMessage(String message) {
	 for (Connection c : listOfConnections) {
			c.out.println(message);
		}
 }
 public void init(int port) throws IOException 
   { 
    ServerSocket serverSocket = null; 

    try { 
         serverSocket = new ServerSocket(port); 
         System.out.println ("Server Socket Created");
         try {
        	 int i = 0;
              while (i<2)
                 {
            	  i++;
                  System.out.println ("Waiting for Connection");
                  Connection connection = new Connection();
                  connection.socket = serverSocket.accept();
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
         System.err.println("Could not listen on port: " + port); 
         System.exit(1); 
        } 
    finally
        {
         try {
              serverSocket.close(); 
             }
         catch (IOException e)
             { 
              System.err.println("Could not close port: " + port); 
              System.exit(1); 
             } 
        }
   }
} 