package ss.week7.cmdline;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

/**
 * Peer for a simple client-server application
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Peer implements Runnable {
    public static final String EXIT = "exit";

    protected String name;
    protected Socket sock;
    protected BufferedReader in;
    protected BufferedWriter out;


    /*@
       requires (nameArg != null) && (sockArg != null);
     */
    /**
     * Constructor. creates a peer object based in the given parameters.
     * @param   nameArg name of the Peer-proces
     * @param   sockArg Socket of the Peer-proces
     */
    public Peer(String nameArg, Socket sockArg) throws IOException
    {
    	name = nameArg;
    	sock = sockArg;
    	in = new BufferedReader(new InputStreamReader(sockArg.getInputStream()));
    	out = new BufferedWriter(new OutputStreamWriter(sockArg.getOutputStream()));
    }

    /**
     * Reads strings of the stream of the socket-connection and
     * writes the characters to the default output.
     */
    public void run() {
    	try {
    		String line;
    		while ((line = in.readLine()) != null) {
    			System.out.println(line);
    			out.flush();
    		}
    		shutDown();
		} catch (SocketException e) {
			if (e.getMessage().equals("Socket closed") || e.getMessage().equals("Connection reset")) {
				System.out.println("Disconnected");
			} else {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }


    /**
     * Reads a string from the console and sends this string over
     * the socket-connection to the Peer process.
     * On Peer.EXIT the method ends
     * @throws IOException 
     * @throws InterruptedException 
     */
    public void handleTerminalInput() throws IOException {
    	try {
		String message = readString("");
		while (message != null && !message.equals("EXIT")) {
			this.out.write(this.getName() + ": " + message);
			this.out.newLine();
			this.out.flush();
			message = readString("");
		}
    	} catch (SocketException e) {
    		System.out.println("Client disconnected");
    	}		
    }

    /**
     * Closes the connection, the sockets will be terminated
     */
    public void shutDown() {
    	try {
			sock.close();
			in.close();
	    	out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    /**  returns name of the peer object*/
    public String getName() {
        return name;
    }

    /** read a line from the default input */
    static public String readString(String tekst) {
        System.out.print(tekst);
        String antw = null;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    System.in));
            antw = in.readLine();
        } catch (IOException e) {
        }

        return (antw == null) ? "" : antw;
    }
}
