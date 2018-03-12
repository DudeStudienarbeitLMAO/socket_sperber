package info.sperber.chat;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;


/**
 * Hello world!
 *
 */
public class App 
{
	static ConcurrentLinkedQueue<String> messages;

    public static void main( String[] args ) throws IOException
    {
		messages = new ConcurrentLinkedQueue<String>();

		ServerSocket server = new ServerSocket(4321);
		Chatroom room = new Chatroom();

		while(true) {
			Socket socket = server.accept();

			if(socket == null)
				continue;

			room.addClient(socket);
		}
    }



}
