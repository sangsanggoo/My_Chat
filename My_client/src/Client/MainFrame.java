package Client;

import java.net.Socket;

import javax.swing.JFrame;

import Client.panel.MainPanel;
import lombok.Getter;

public class MainFrame extends JFrame {
	private static MainFrame instance;
	@Getter
	private static Socket socket;
	
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	public MainFrame() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 839);
		setContentPane(MainPanel.getInstance());


	}
}
