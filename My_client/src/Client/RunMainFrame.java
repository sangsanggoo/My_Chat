package Client;

import Client.Frame.MainFrame;

public class RunMainFrame extends Thread{
	@Override
	public void run() {
		MainFrame frame = MainFrame.getInstance();
		frame.setVisible(true);
	}

}
