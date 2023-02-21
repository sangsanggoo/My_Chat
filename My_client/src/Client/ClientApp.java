package Client;

import java.awt.EventQueue;
import java.io.IOException;
import java.net.Socket;

import lombok.Getter;

public class ClientApp extends Thread {
	private static ClientApp instance;
	@Getter
	private static Socket socket;

	
	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			
			
			@Override
			public void run() {
				String ip = "127.0.0.1";
				int port = 1234;
				try {
					socket = new Socket(ip,port);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RunMainFrame runMainFrame = new RunMainFrame();
				runMainFrame.start();
				My_ClientRecieve my_ClientRecieve = new My_ClientRecieve(socket);
				my_ClientRecieve.start();
				
				
				
			}
		};
		EventQueue.invokeLater(runnable);

	}
	
}
