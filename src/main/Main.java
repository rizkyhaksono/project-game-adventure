package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("2D Adventure");
		
		GamePanel gamePanel = new GamePanel();
		
		window.add(gamePanel);
		
		window.pack(); //Sizing window to the preferred size and also all its layouts/subcomponents, gamepanel for example
		
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.setObjects();
		gamePanel.startGameThread();
		
	}

}
