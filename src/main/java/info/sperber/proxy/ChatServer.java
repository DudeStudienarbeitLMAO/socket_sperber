package info.sperber.proxy;


import java.rmi.RemoteException;
import java.util.List;


public class ChatServer implements ChatServerInterface
{
	public void addMessage(String message) throws RemoteException {
		System.out.println("chatted " + message);
	}

	public List<String> pollMessages(int fromPosition) throws RemoteException {
		return null;
	}
}
