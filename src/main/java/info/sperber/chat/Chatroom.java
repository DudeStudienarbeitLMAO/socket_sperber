package info.sperber.chat;


import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Chatroom
{
	List<Client> client;

	public Chatroom() {
		client = new ArrayList<Client>();
	}

	public void addClient(Socket socket) {
		Client cli = new Client(socket, this);
		client.add(cli);
		cli.run();
	}

	public void broadcast(String message) {
		for(Client c : client) {
			c.printMessage(message);
		}
	}
}
