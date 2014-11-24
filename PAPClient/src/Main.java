import java.io.IOException;


public class Main {
	public static void main(String[] args) throws IOException{
		String serverName = "127.0.0.1";
		int port = 10008;
		Client client = new Client();
		client.init(serverName, port);
	}
}
