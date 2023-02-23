                                                                                                                                                      package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;

import Dto.RequestDto;
import Dto.ResponseDto;
import lombok.Getter;
import repository.Room;
import repository.RoomRepository;
import repository.User;
import repository.UserRepository;

public class ConnectedSocket extends Thread {
	@Getter
	private Socket socket;	
	private InputStream inputStream;
	private OutputStream outputStream;
	private Gson gson;
	private User user;
	private Room room;
	public ConnectedSocket(Socket socket) {
		this.socket = socket;
		gson = new Gson();
	}
	
	@Override
	public void run() {
		try {
			inputStream = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));


			while(true) {
				String request = in.readLine();
				RequestDto requestDto = gson.fromJson(request, RequestDto.class);

				switch(requestDto.getResource()) {
//					로그인 받음
					case "login":
						user = new User(requestDto.getBody());
						UserRepository.getInstance().getUserlist().add(user);
						System.out.println(UserRepository.getInstance().getUserlist());
						sendResponse(requestDto.getResource(),gson.toJson(user));
						break;
//					방생성 받음
					case "createroom":
						room = new Room(requestDto.getBody());
						RoomRepository.getInstance().getRoomliList().add(room);
						System.out.println(RoomRepository.getInstance().getRoomliList());
						
						sendResponse("createroom",gson.toJson(RoomRepository.getInstance().getRoomliList()));
						break;
//					로그인 받음
					case "showroomlist" :
						System.out.println(gson.toJson(RoomRepository.getInstance().getRoomliList()));
						sendResponse(requestDto.getResource(), gson.toJson(RoomRepository.getInstance().getRoomliList()));
						break;
						
			
				}
			}	
		} catch (IOException e) {
		}
		
		
	}
	
	private void sendResponse(String resource, String body) throws IOException {
		ResponseDto responseDto = new ResponseDto(resource, body);
		outputStream = socket.getOutputStream();
		PrintWriter out = new PrintWriter(outputStream, true);
		out.println(gson.toJson(responseDto));
	}
	
	

}
