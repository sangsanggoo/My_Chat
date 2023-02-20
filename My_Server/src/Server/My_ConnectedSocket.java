package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import Dto.RequestDto;
import Dto.ResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
@AllArgsConstructor
public class My_ConnectedSocket extends Thread {
	private Socket socket;
	private static List<My_ConnectedSocket> connectedSockets = new ArrayList<>();
	private static List<String> userList = new ArrayList<>();
	private User user ;
	private InputStream inputStream;
	private OutputStream outputStream;
	Gson gson = new Gson();
	
	public My_ConnectedSocket(Socket socket) {
		this.socket = socket;
		connectedSockets.add(this);
	}
	@Override
	public void run() {
		
			try {
				inputStream = socket.getInputStream();
				BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
				
				while(true) {
					String request = in.readLine();
					RequestDto requestDto = gson.fromJson(request,RequestDto.class);
					
					switch(requestDto.getResource()) {
					case "login" :
						userList.add(requestDto.getBody());
						outputStream = socket.getOutputStream();
						PrintWriter out = new PrintWriter(outputStream, true);
						out.println(new RequestDto(requestDto.getResource(),requestDto.getBody()));
						System.out.println(gson.toJson(new ResponseDto(requestDto.getResource(),requestDto.getBody()), RequestDto.class));
					}
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
	
	
}

