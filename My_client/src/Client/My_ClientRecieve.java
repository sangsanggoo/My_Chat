package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


public class My_ClientRecieve extends Thread {
	private static Socket socket;
	
	public My_ClientRecieve(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			Gson gson = new Gson();

			InputStream inputStream = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			String response = in.readLine();
			System.out.println(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


	
	

}
