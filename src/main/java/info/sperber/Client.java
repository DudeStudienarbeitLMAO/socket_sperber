package info.sperber;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client
{
	Socket socket;
	Chatroom room;

	public Client(Socket socket, Chatroom room) {
		this.socket = socket;
		this.room = room;
	}

	public void run() {
		Runnable r = new Runnable() {
			public void run() {
				handleConnection(socket);
			}
		};

		new Thread(r).start();
	}

	public void printMessage(String message) {
		try {
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.println(message);
		}
		catch(IOException e) {

		}
	}

	private void handleConnection(Socket client) {

		try {
			while(true) {
				Scanner in = new Scanner(client.getInputStream());

				String input = in.nextLine();
				if (input.equals("exit"))
					break;
				
				room.broadcast(input);

				printMessage(String.format("You entered: %s", input));
			}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		finally
		{
			try {
				client.close();
			}
			catch(IOException e) {}
		}
	}
}
