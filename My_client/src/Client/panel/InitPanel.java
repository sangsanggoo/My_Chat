package Client.panel;


import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.google.gson.Gson;

import Client.Dto.RequestDto;

public class InitPanel extends JPanel{
	
	private final int WIDTH = 480;
	private final int HEIGHT = 800;
	public final Color kakaoColor = new Color(249, 224, 0);
	public final Color kakaoColor2 = new Color(254, 229, 0);
	private Socket socket ;
	private Gson gson;
	
	public InitPanel() {

		setLayout(null);
		setBorder(null);
		setSize(WIDTH, HEIGHT);

		socket = Client.MainFrame.getSocket();
		gson = new Gson();
		
		

	}
	
//	이미지 추가 메소드
	public ImageIcon addImage(String imageName, int width, int length) {
		ImageIcon image = new ImageIcon("./image/" + imageName);
		ImageIcon resizedImage = new ImageIcon(image.getImage().getScaledInstance(width, length, Image.SCALE_SMOOTH));
		return resizedImage;
	}

//	requestDto 서버로 보내기
	public void sendDto(RequestDto requestDto) {
		OutputStream outputStream;
		try {
			outputStream = socket.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream,true);
			printWriter.print(gson.toJson(requestDto));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
