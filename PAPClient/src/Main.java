import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException{
		String serverName = "127.0.0.1";
		int port = 10008;
		Client client = new Client();
		Connection connection = client.init(serverName, port);
		
		BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
		String userInput;

		System.out.println ("Type Message (\"Bye.\" to quit)");
		while ((userInput = stdIn.readLine()) != null) 
		{
			connection.out.println(userInput);

			// end loop
			if (userInput.equals("Bye."))
				break;
			
			System.out.println("echo: " + connection.in.readLine());
		}
		connection.close();

		stdIn.close();
	}
}
