package info.sperber.proxy;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ChatClient
{
	public static void main(String[] args) throws RemoteException, NotBoundException
	{
		Registry registry = LocateRegistry.getRegistry();
		ChatServerInterface csi = (ChatServerInterface) registry.lookup("ChatServer");
		csi.addMessage("TEST");
	}
}
