import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection {
	public Socket socket = null;
    public PrintWriter out = null;
    public BufferedReader in = null;
    
    public void close() throws IOException {
    	socket.close();
    	out.close();
    	in.close();
    }
}