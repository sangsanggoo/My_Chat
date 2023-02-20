package Server;

import java.net.Socket;

import lombok.Data;
@Data
public class ConnectedSocket extends Thread {
	private Socket socket;
	
	
	public ConnectedSocket(Socket socket) {
		this.socket = socket;
		
	}
}
