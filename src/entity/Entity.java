package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {

	//Storing variables that will be used in player, monster and NPC classes
	
	
	public int worldX, worldY;
	public int speed;
	
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	public String direction;
	
	public int spriteCounter = 0;
	public int spriteNumber = 1;
	
	public Rectangle solidArea; //creating invisible rectangle to store data
	public int solidAreaDefaultX, solidAreaDefaultY;
	
	
	public boolean collisionOn = false;
	
	
	
}
