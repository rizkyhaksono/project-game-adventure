package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperObject {

	public BufferedImage objectImage;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	
	public void draw(Graphics2D g2, GamePanel gamePanel) {
		int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX; //players position is always on the center on the screen -> 0-0 tile is really in different place since it's outside of our game window, so we need to do some offsetting.
		int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;
		
		//Drawing images while we move to render with better performance
		if(worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX && 
			worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
			worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY &&
			worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY) {
			g2.drawImage(objectImage, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
		}
	}
	
	
}
