package Client;

import java.awt.CardLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import Client.Dto.ResponseDto;
import Client.Repository.Room;
import Client.Repository.RoomRepository;
import Client.Repository.User;
import Client.panel.MainPanel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientRecive extends Thread{
	
	private final Socket socket;
	private InputStream inputStream;
	private Gson gson;
	private CardLayout mainCard;
	private Room room;
	private User user;
	@Override
	public void run() {
		try {
			inputStream = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			gson = new Gson();
			
		
			
			while(true) {
				String response = in.readLine();
				ResponseDto responseDto = gson.fromJson(response, ResponseDto.class);
				switch(responseDto.getResource()) {
					case "login":
						mainCard = MainPanel.getMainCard();
						mainCard.show(MainPanel.getInstance(), "menuPanel");
						break;
					case "showroomlist" :
						System.out.println(responseDto.getBody());
						break;
					case "createroom" :
						mainCard = MainPanel.getMainCard();
						mainCard.show(MainPanel.getInstance(), "loginpanel");
						List<Room> roomlist = gson.fromJson(responseDto.getBody(), List.class);
						System.out.println(roomlist);
						break;
				}
			}
			

			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
