package Client;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
@AllArgsConstructor
public class ClientApp extends Thread {
	
	private static Socket socket;
	private Gson gson;
	private CardLayout mainCard;
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
