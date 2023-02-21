package Client.panel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.google.gson.Gson;

import Client.MainFrame;
import Client.Dto.RequestDto;

public class LoginPanel extends InitPanel {
	
	private static LoginPanel instance;
	private OutputStream outputStream ;
	private InputStream inputStream;
	public static LoginPanel getInstance() {
		if(instance == null) {
			instance = new LoginPanel();
		}
		
		return instance;
	};

	private CardLayout mainCard;
	private JTextField usernameField;
	private static String username;
	private Socket socket ;

	private Gson gson;
	

	private LoginPanel() {	
		socket = MainFrame.getSocket();
		gson = new Gson();
		
		setBackground(kakaoColor);
		mainCard = MainPanel.getMainCard();
		
//		로고
		JLabel logoLabel = new JLabel(addImage("logo.png", 80, 80));
		add(logoLabel);
		logoLabel.setBounds(200, 200, 80, 80);
		

		
		
//		로그인 버튼
		
		JButton loginButton = new JButton(addImage("loginbutton.png", 280, 40));
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				username = usernameField.getText();
				RequestDto requestDto = new RequestDto("login",username);
				try {
					outputStream = socket.getOutputStream();
					PrintWriter printWriter = new PrintWriter(outputStream,true);
					printWriter.print(gson.toJson(requestDto));
					System.out.println(gson.toJson(requestDto));
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
			}
		});
		loginButton.setBackground(new Color(254, 229, 0));
		loginButton.setBounds(100, 440, 280, 40);
		add(loginButton);
		


		
//		username 입력창
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("D2Coding", Font.BOLD, 17));
		usernameField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameField.setBounds(100, 380, 280, 45);
		add(usernameField);
		usernameField.setColumns(10);		
	}
	

	
}
