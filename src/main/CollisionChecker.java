package main;

import entity.Entity;

public class CollisionChecker {

	
	GamePanel gamePanel;
	
	public CollisionChecker(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	public void CheckTile(Entity entity) {
		
		int entityLeftWorldX = entity.worldX + entity.solidArea.x + 25;
		int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.worldY + entity.solidArea.y +25;
		int entityBotWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height; //TODO: check bottom collision to make moving more smooth.. Now when movin right or left when collidin with bottom, we rly cant move..
		
		
		
		int entityLeftCol = entityLeftWorldX/gamePanel.tileSize;
		int entityRightCol = entityRightWorldX/gamePanel.tileSize;
		int entityTopRow = entityTopWorldY/gamePanel.tileSize;
		int entityBotRow = entityBotWorldY/gamePanel.tileSize;
		
		int tileNumber1, tileNumber2;
		
		switch(entity.direction) {
			
		case "up":
			entityTopRow = (entityTopWorldY - entity.speed)/gamePanel.tileSize;
			tileNumber1 = gamePanel.tileManager.mapTileNumber[entityLeftCol][entityTopRow]; //left side
			tileNumber2 = gamePanel.tileManager.mapTileNumber[entityRightCol][entityTopRow]; //right side
				if(gamePanel.tileManager.tile[tileNumber1].collision == true || gamePanel.tileManager.tile[tileNumber2].collision == true) {
					entity.collisionOn=true;
				}
			break;
			
		case "down":
			entityBotRow = (entityBotWorldY - entity.speed)/gamePanel.tileSize;
			tileNumber1 = gamePanel.tileManager.mapTileNumber[entityLeftCol][entityBotRow]; //left side
			tileNumber2 = gamePanel.tileManager.mapTileNumber[entityRightCol][entityBotRow]; //right side
				if(gamePanel.tileManager.tile[tileNumber1].collision == true || gamePanel.tileManager.tile[tileNumber2].collision == true) {
					entity.collisionOn=true;
				}
			
			break;
		case "left":
			
			entityLeftCol = (entityLeftWorldX - entity.speed)/gamePanel.tileSize;
			tileNumber1 = gamePanel.tileManager.mapTileNumber[entityLeftCol][entityTopRow]; //left side
			tileNumber2 = gamePanel.tileManager.mapTileNumber[entityLeftCol][entityBotRow]; //right side
				if(gamePanel.tileManager.tile[tileNumber1].collision == true || gamePanel.tileManager.tile[tileNumber2].collision == true) {
					entity.collisionOn=true;
				}
			
			break;
		case "right":
			entityRightCol = (entityRightWorldX - entity.speed)/gamePanel.tileSize;
			tileNumber1 = gamePanel.tileManager.mapTileNumber[entityRightCol][entityTopRow]; //left side
			tileNumber2 = gamePanel.tileManager.mapTileNumber[entityRightCol][entityBotRow]; //right side
				if(gamePanel.tileManager.tile[tileNumber1].collision == true || gamePanel.tileManager.tile[tileNumber2].collision == true) {
					entity.collisionOn=true;
				}
			break;
		}
		
	}
	
	public int checkObject(Entity entity, boolean player) {
		//Check if player is hitting any object, if so, we return index of the object
		int index = 999;
		
		for(int i = 0; i < gamePanel.objects.length; i++) {
			//scan objects array
			
			if(gamePanel.objects[i] != null) {
				//get entity's solid area position
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;
				
				//Get the objects solid area position
				gamePanel.objects[i].solidArea.x = gamePanel.objects[i].worldX + gamePanel.objects[i].solidArea.x;
				gamePanel.objects[i].solidArea.y = gamePanel.objects[i].worldY + gamePanel.objects[i].solidArea.y;
				
				switch(entity.direction) {
				
				case "up":
					entity.solidArea.y -= entity.speed;
					if(entity.solidArea.intersects(gamePanel.objects[i].solidArea)) {
						if(gamePanel.objects[i].collision == true) {
							entity.collisionOn = true;
						}
						if(player == true) {
							index = i;
						}
					}
					break;
				case "down":
					entity.solidArea.y += entity.speed;
					if(entity.solidArea.intersects(gamePanel.objects[i].solidArea)) {
						if(gamePanel.objects[i].collision == true) {
							entity.collisionOn = true;
						}
						if(player == true) {
							index = i;
						}
					}
					break;
				case "left":
					entity.solidArea.x -= entity.speed;
					if(entity.solidArea.intersects(gamePanel.objects[i].solidArea)) {
						if(gamePanel.objects[i].collision == true) {
							entity.collisionOn = true;
						}
						if(player == true) {
							index = i;
						}
					}
					break;
				case "right":
					entity.solidArea.x += entity.speed;
					if(entity.solidArea.intersects(gamePanel.objects[i].solidArea)) {
						if(gamePanel.objects[i].collision == true) {
							entity.collisionOn = true;
						}
						if(player == true) {
							index = i;
						}
					}
					break;
				
				}
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				gamePanel.objects[i].solidArea.x = gamePanel.objects[i].solidAreaDefaultX;
				gamePanel.objects[i].solidArea.y = gamePanel.objects[i].solidAreaDefaultY;
			}
			
		}
		
		return index;
		
	}
	
}
