package main;

import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;

public class AssetHandler {

	GamePanel gamePanel;
	
	public AssetHandler(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	public void setObject() {
		
		this.gamePanel.objects[0] = new OBJ_Key();
		this.gamePanel.objects[0].worldX = 10 * gamePanel.tileSize;
		this.gamePanel.objects[0].worldY = 10 * gamePanel.tileSize;
		
		this.gamePanel.objects[1] = new OBJ_Key();
		this.gamePanel.objects[1].worldX = 30 * gamePanel.tileSize;
		this.gamePanel.objects[1].worldY = 20 * gamePanel.tileSize;
		

		this.gamePanel.objects[2] = new OBJ_Chest();
		this.gamePanel.objects[2].worldX = 10 * gamePanel.tileSize;
		this.gamePanel.objects[2].worldY = 9 * gamePanel.tileSize;
		
		this.gamePanel.objects[3] = new OBJ_Door();
		this.gamePanel.objects[3].worldX = 15 * gamePanel.tileSize;
		this.gamePanel.objects[3].worldY = 9 * gamePanel.tileSize;
		
		this.gamePanel.objects[4] = new OBJ_Boots();
		this.gamePanel.objects[4].worldX = 16 * gamePanel.tileSize;
		this.gamePanel.objects[4].worldY = 9 * gamePanel.tileSize;
		
	}
	
}
