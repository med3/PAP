
import java.io.*;
import java.net.Socket;

public class Connection extends Thread{
	public Socket socket = null;
    

	public PrintWriter out = null;
    public BufferedReader in = null;
    /*public BlockingQueue<String> messageQueue;
      }
    public Connection(){
    	messageQueue = new BlockingQueue<String>()
            
          
    }
    */
    
    public void sendMessage(String message) {
    	out.println(message);
    }
    
    public void run()
    {
     System.out.println ("New Connection Thread Startedd");

     try {
    	 
    	 
    	 out = new PrintWriter(socket.getOutputStream(), true);
         in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    	 
    	 System.out.println("Created input and output streams");
          
    	 String inputLine;
         while ((inputLine = in.readLine()) != null) 
    	 { 	
        	 System.out.println ("Received: " + inputLine); 
          
          }

          out.close(); 
          in.close(); 
          socket.close(); 
         } 
     catch (IOException e) 
         { 
          System.err.println("Problem with Communication Server");
          System.exit(1); 
         } 
 
     }
    
    public void close() throws IOException {
    	socket.close();
    	out.close();
    	in.close();
    }


}