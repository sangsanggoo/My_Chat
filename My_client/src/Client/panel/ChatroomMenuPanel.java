package Client.panel;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ChatroomMenuPanel extends InitPanel {

	private static ChatroomMenuPanel instance;
	
	public static ChatroomMenuPanel getInstance() {
		if(instance == null) {
			instance = new ChatroomMenuPanel();
		}
		
		return instance;
	};
	public ChatroomMenuPanel() {

		setBackground(kakaoColor);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(242, 35, 238, 664);
		add(scrollPane);

		JList list = new JList();
		scrollPane.setViewportView(list);
		
		// 나가기 버튼
		ImageIcon plusbuttonIcon = new ImageIcon("./image/exitbutton.png");
		ImageIcon resizedplusbuttonIcon = new ImageIcon(plusbuttonIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		JButton btnNewButton = new JButton(resizedplusbuttonIcon);

		
		btnNewButton.setBounds(364, 718, 104, 54);
		add(btnNewButton);
		
		
		
	}

}
