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
import Client.panel.MainPanel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


public class My_ClientRecieve extends Thread {
	private  Socket socket;
	private CardLayout mainCard;
	public static List<String> userList = new ArrayList<>();
	public My_ClientRecieve(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			Gson gson = new Gson();
			while(true) {
			InputStream inputStream = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			String response = in.readLine();
			ResponseDto responseDto = gson.fromJson(response, ResponseDto.class);
			switch(responseDto.getBody()) {
			case "login" :
				userList.add(responseDto.getBody());
				mainCard= MainPanel.getMainCard();
				mainCard.show(MainPanel.getInstance(), "menuPanel");
				break;
			}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


	
	

}
