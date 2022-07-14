package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {

	GamePanel gamePanel;
	public Tile[] tile;
	
	public int mapTileNumber[][];
	
	public TileManager(GamePanel gamePanel) {
		
		this.gamePanel = gamePanel;
		tile = new Tile[10];
		mapTileNumber = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];
		
		
		getTileImage();
		loadMap("/maps/world01map.txt");
	}
	
	public void getTileImage() {
		
		try {
			tile[0] = new Tile();
			tile[0].tileImage = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			
			tile[1] = new Tile();
			tile[1].tileImage = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			tile[1].collision = true;
			
			tile[2] = new Tile();
			tile[2].tileImage = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
			tile[2].collision = true;
			
			tile[3] = new Tile();
			tile[3].tileImage = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
			
			tile[4] = new Tile();
			tile[4].tileImage = ImageIO.read(getClass().getResourceAsStream("/tiles/tree_dark_w_bg.png"));
			tile[4].collision = true;
			
			tile[5] = new Tile();
			tile[5].tileImage = ImageIO.read(getClass().getResourceAsStream("/tiles/ground.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadMap(String mapPath) {
		try {
			
			InputStream inputStream = getClass().getResourceAsStream(mapPath);
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			
			int col = 0;
			int row = 0;
			
			while(col < gamePanel.maxWorldCol && row < gamePanel.maxWorldRow) {
				
				String line = br.readLine();
				System.out.println("col " + col);
				System.out.println("row " + row);
				while(col < gamePanel.maxWorldCol) {
					
					String numbers[] = line.split(" ");
					
					int number = Integer.parseInt(numbers[col]);
					
					mapTileNumber[col][row] = number;
					col++;
					
				}
				if(col == gamePanel.maxWorldCol) {
					System.out.println("col2 " + col);
					col = 0;
					row++;
				}
				
			}
			br.close();
		}catch(Exception e) {
			
		}
	}
	
	
	public void draw(Graphics2D g2) {

		int worldCol = 0;
		int worldRow = 0;
		
		while(worldCol < gamePanel.maxWorldCol && worldRow < gamePanel.maxWorldRow) {
			
			int tileNumber = mapTileNumber[worldCol][worldRow];
			
			//System.out.println("tilen" + tileNumber + "mtn " + mapTileNumber[worldCol][worldRow]);
			
			int worldX = worldCol * gamePanel.tileSize; // first checking tiles of world01map... WorldX = position of map and ScreenX = where to draw it on the map -> I.E. if player is on 100x100 tile, tile 0-0 is 100x100 from the player, and if we move we have to ofc draw(/scale) this shit again to make it look like camera 
			int worldY = worldRow * gamePanel.tileSize;
			int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX; //players position is always on the center on the screen -> 0-0 tile is really in different place since it's outside of our game window, so we need to do some offsetting.
			int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;
			
			//Drawing images while we move to render with better performance
			if(worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX && 
				worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
				worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY &&
				worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY) {
				g2.drawImage(tile[tileNumber].tileImage, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
			}
			
			worldCol++;
			
			
			if(worldCol == gamePanel.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			}
			
		}
		
		
		
	}
	
}
