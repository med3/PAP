import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
		int port = 10008;
		Server server = new Server();
		server.init(port);
	}
}
