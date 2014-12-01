import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
		int port = Integer.parseInt(args[0]);//10008;
		Server server = new Server(port);
		while (true){
			System.out.print("\nEnter something:");
			String input = System.console().readLine();
			if(input.equals("read")) {
				System.out.println(server.receiveMessageAsynchrone());
			} else {
				server.sendMessage(input);
			}
		}
	}
}
