
import java.io.*;
import java.net.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Connection extends Thread{
	public Socket socket = null;
    public SocketAddress socketAddress= null;

	private PrintWriter out = null;
    private BufferedReader in = null;
    private BlockingQueue<String> messageQueue;
    
    public Connection(){
    	messageQueue = new ArrayBlockingQueue<String>(1024);
    }
    
    
    public void sendMessage(String message) {
    	out.println(message);
    }
    
    public String receiveMessageAsynchrone() {
			return messageQueue.poll(); //returns null if empty
    }
    public String receiveMessageSynchrone() {
		try {
			return messageQueue.take(); //waits until new message is received
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
        	 messageQueue.put(inputLine);
          }

          out.close(); 
          in.close(); 
          socket.close(); 
         } 
     catch (IOException e) 
         { 
          System.err.println("Problem with Communication Server");
          System.exit(1); 
         } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
 
     }
    
    public void close() throws IOException {
    	socket.close();
    	out.close();
    	in.close();
    }


}