package Client.panel;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import lombok.Getter;
import lombok.Setter;

public class ChatroomPanel extends InitPanel {
	
	private static ChatroomPanel instance;
	
	public static ChatroomPanel getInstance() {
		if(instance == null) {
			instance = new ChatroomPanel();
		}
		
		return instance;
	};
	
	private CardLayout mainCard;
	@Getter
	private JLabel roomnameLabel;
	
	
	@Setter
	@Getter
	private JTextArea contentArea;
	


	public ChatroomPanel() {

		mainCard = MainPanel.getMainCard();
		
		setBackground(kakaoColor);
		
		// 로고 이미지
		JLabel logoLabel = new JLabel(addImage("logo.png", 40, 40));
		logoLabel.setBounds(20, 20, 40, 40);
		add(logoLabel);
		
		// 리스트 버튼
		JButton listButton = new JButton(addImage("listbutton.png", 30, 30));

		
		add(listButton);
		listButton.setBounds(410, 20, 40, 40);
		listButton.setBackground(kakaoColor);
		
		
		// 방제목 Label
		roomnameLabel = new JLabel();
		roomnameLabel.setFont(new Font("D2Coding", Font.BOLD, 22));
		roomnameLabel.setText("111");
		roomnameLabel.setBounds(90, 20, 280, 40);
		add(roomnameLabel);
		
		// 메세지 내용 패널
		JScrollPane chatContentPanel = new JScrollPane();
		chatContentPanel.setBounds(0, 80, 480, 600);
		add(chatContentPanel);
		
		// 메세지 내용 Area
		contentArea = new JTextArea();
		chatContentPanel.setViewportView(contentArea);
		
		// 메세지 보내기 패널
		
		JScrollPane messagePanel = new JScrollPane();
		messagePanel.setBounds(0, 680, 390, 120);
		add(messagePanel);
		
		JTextArea messageInput = new JTextArea();
		messagePanel.setViewportView(messageInput);
		
		// 메세지 보내기 아이콘
		JButton sendButton = new JButton(addImage("send.png", 40, 40));

		sendButton.setBounds(390, 680, 90, 120);
		sendButton.setBackground(new Color(255, 255, 255));
		add(sendButton);
		
		
		
		
	}
}
