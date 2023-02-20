package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import lombok.Getter;

public class ServerApp {
	private Socket socket ;
	
	public static void main(String[] args) {
		ServerSocket serverSocket ;
		
			try {
				serverSocket = new ServerSocket(1234);
				System.out.println("서버 시작");
				while(true) {
					Socket socket = serverSocket.accept();
					My_ConnectedSocket connectedSocket = new My_ConnectedSocket(socket);
					connectedSocket.start();
					
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				System.out.println("서버 종료");
			}
			
		}
	
}
