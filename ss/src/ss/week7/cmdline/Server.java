
package ss.week7.cmdline;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
	
/**
 * Server. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Server {
    private static final String USAGE
        = "usage: " + Server.class.getName() + " <name> <port>";
	private static ServerSocket sock;

    /** Starts a Server-application. 
     * @throws IOException */
    public static void main(String[] args) throws IOException {
    	if (args.length != 2) {
            System.out.println(USAGE);
            System.exit(0);
        }
    	
    	int port = 0;
    	String name = args[0];
    	SocketAddress addr = null;
    	 
    	try {
            port = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println(USAGE);
            System.out.println("ERROR: port " + args[1]
            		           + " is not an integer");
            System.exit(0);
        }
    	
		try {
			addr = new InetSocketAddress(InetAddress.getLocalHost(), port);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		sock = new ServerSocket();
		sock.bind(addr, port);
        Peer server = new Peer(name, sock.accept());
        Thread streamInputHandler = new Thread(server);
        streamInputHandler.start();
        server.handleTerminalInput();
        server.shutDown();
        sock.close();
    }

} // end of class Server
