import java.io.IOException;


public class Main {
	public static void main(String[] args) throws IOException, InterruptedException{
		String serverName = args[0];//"127.0.0.1";
		int port = Integer.parseInt(args[1]);//10008;
		Client client = new Client();
		client.init(serverName, port);
		while (true){
			System.out.print("\nEnter something:");
			String input = System.console().readLine();
			if(input.equals("read")) {
				System.out.print(client.receiveMessageAsynchrone());
			} else {
				client.sendMessage(input);
			}
		}
	}
}
