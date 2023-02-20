package Client;

import java.awt.EventQueue;
import java.io.IOException;
import java.net.Socket;

public class ClientApp {
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
				
				
			}
		};
		EventQueue.invokeLater(runnable);

	}
	
}
