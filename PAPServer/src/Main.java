import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
		int port = Integer.parseInt(args[0]);//10008;
		Server server = new Server();
		server.init(port);
		while (true){
			System.out.print("Enter something:");
			String input = System.console().readLine();
			server.sendMessage(input);
		}
	}
}
