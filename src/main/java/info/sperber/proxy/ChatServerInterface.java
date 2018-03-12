package info.sperber.proxy;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface ChatServerInterface extends Remote
{
	void addMessage(String message) throws RemoteException;
	List<String> pollMessages(int fromPosition) throws RemoteException;
}
