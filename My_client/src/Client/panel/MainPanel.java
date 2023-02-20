package Client.panel;

import java.awt.CardLayout;

import lombok.Getter;

public class MainPanel extends InitPanel {
	
	private static MainPanel instance;
	
	public static MainPanel getInstance() {
		if(instance == null) {
			instance = new MainPanel();
		}
		
		return instance;
	};

	@Getter
	private static CardLayout mainCard;

	private MainPanel() {
		mainCard = new CardLayout();
		setLayout(mainCard);
		
		add(LoginPanel.getInstance(), "loginPanel");
		add(MenuPanel.getInstance(), "menuPanel");
		add(ChatroomPanel.getInstance(), "chatroomPanel");
		add(ChatroomMenuPanel.getInstance(), "chatroomMenuPanel");
		
		mainCard.show(this, "loginPanel");
	}
	

	
}
