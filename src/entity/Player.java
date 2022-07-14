package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{

	
	GamePanel gamePanel;
	KeyHandler keyHandler;
	
	public final int screenX;
	public final int screenY;
	int hasKey = 0;
	
	public Player(GamePanel gamePanel, KeyHandler keyHandler) {
		this.gamePanel = gamePanel;
		this.keyHandler = keyHandler;
		
		screenX = gamePanel.screenWidth/2 -(gamePanel.tileSize/2); //To center player on the screen -> we're gonna scroll the background as player moves
		screenY = gamePanel.screenHeight/2-(gamePanel.tileSize/2);
		
		
		solidArea = new Rectangle(0, 0, gamePanel.tileSize-(int)(gamePanel.tileSize*0.3), gamePanel.tileSize-(int)(gamePanel.tileSize*0.3));
		solidAreaDefaultY = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		this.setDefaultValues();
		this.getPlayerImage();
		
		
		
	}
	
	public void setDefaultValues() {
		
		this.worldX = gamePanel.tileSize * 23; //Players position on world map
		this.worldY = gamePanel.tileSize * 21;
		this.speed = 4;
		direction ="down";
		
	}
	
	public void getPlayerImage(){
		
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/down1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update() {
		
		if(keyHandler.upPressed == true || keyHandler.downPressed == true || keyHandler.leftPressed == true || keyHandler.rightPressed == true) {
		//If above is basically for that we're going to make player walk only if key is being pressed
		if(keyHandler.upPressed == true) {
			direction = "up";
			
		}
		else if(keyHandler.downPressed == true) {
			direction = "down";
			
		}
		else if(keyHandler.leftPressed == true) {
			direction = "left";
			
		}
		else if(keyHandler.rightPressed == true) {
			direction = "right";
			
		}
		
		//CHECK TILE COLLISION
		collisionOn = false;
		gamePanel.collisionChecker.CheckTile(this);
		
		//CHECK OBJECT COLLISION
		int objIndex = gamePanel.collisionChecker.checkObject(this, true);
		pickUpObject(objIndex);
		//IF TILE COLLISION IS FALSE, PLAYER CAN MOVE
		if(collisionOn == false) {
			switch(direction) {
			case "up":
				this.worldY -= this.speed;
				break;
			case "down":
				this.worldY += this.speed;
				break;
			case "left":
				this.worldX -= this.speed;
				break;
			case "right":
				this.worldX += this.speed;
				break;
			}
		}
		
		//Down here, we're calling this 60 per second. --> increasing spritecounter --> changing image every 12 frames to make things smoother
		this.spriteCounter++;
		if(this.spriteCounter > 12) {
			if(this.spriteNumber == 1) {
				this.spriteNumber = 2;
			}
			else if(this.spriteNumber == 2) {
				this.spriteNumber = 1;
			}
			spriteCounter = 0;
		}
		}
	}
	
	public void pickUpObject(int i) {
		
		if(i != 999) {
			//if index is not 999, we're touching an object
			String objectName = gamePanel.objects[i].name;
			
			switch(objectName) {
			case "key":
				hasKey++;
				gamePanel.playSoundEffect(0);
				gamePanel.objects[i] = null;
				System.out.println("key");
				break;
				
			case "door":
				if(hasKey > 0) {
					gamePanel.playSoundEffect(1);
					gamePanel.objects[i]=null;
					hasKey--;
				}
				break;
			
			case "boots":
				gamePanel.objects[i]=null;
				gamePanel.playSoundEffect(4);
				speed += 2;
				System.out.println("boots");
			break;
		}
		}
		
	}
	
	
	public void draw(Graphics2D graphics2D) {
		//graphics2D.setColor(Color.white);
		//graphics2D.fillRect(this.x, this.y, gamePanel.tileSize, gamePanel.tileSize);
		
		BufferedImage image = null;
		
		switch(direction) {
		
		case "up":
			if(this.spriteNumber==1) {
			image = up1;
			}
			if(this.spriteNumber==2) {
			image = up2;
			}
			break;
		case "down":
			if(this.spriteNumber==1) {
				image = down1;
				}
			if(this.spriteNumber==2) {
				image = down2;
				}
			break;
		case "left":
			if(this.spriteNumber==1) {
				image = left1;
				}
			if(this.spriteNumber==2) {
					image = left2;
				}
			break;
		case "right":
			if(this.spriteNumber==1) {
				image = right1;
				}
			if(this.spriteNumber==2) {
					image = right2;
				}
			break;
		
		}
		graphics2D.drawImage(image, screenX, screenY, this.gamePanel.tileSize, this.gamePanel.tileSize, null);
		
	}
}
