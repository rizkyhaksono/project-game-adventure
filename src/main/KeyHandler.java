package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

	
	public boolean upPressed;
	public boolean leftPressed;
	public boolean downPressed;
	public boolean rightPressed;
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		
		int keyCode = arg0.getKeyCode();
		
		if(keyCode == KeyEvent.VK_W) {
			upPressed = true;
		}
		
		if(keyCode == KeyEvent.VK_A) {
			leftPressed = true;
		}
		
		if(keyCode == KeyEvent.VK_S) {
			downPressed = true;
		}
		
		if(keyCode == KeyEvent.VK_D) {
			rightPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
int keyCode = arg0.getKeyCode();
		
		if(keyCode == KeyEvent.VK_W) {
			upPressed = false;
		}
		
		if(keyCode == KeyEvent.VK_A) {
			leftPressed = false;
		}
		
		if(keyCode == KeyEvent.VK_S) {
			downPressed = false;
		}
		
		if(keyCode == KeyEvent.VK_D) {
			rightPressed = false;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
		
	}

}
