package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	
	//SCREEN SETTINGS
	
	final int originalTileSize = 16; //16x16 tile
	final int scale = 3; //for scaling since resolutions are nowadays bit higher..
	public final int tileSize = originalTileSize * scale;
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12; //3:4 ratio
	public final int screenWidth = tileSize * maxScreenCol; //768
	public final int screenHeight = tileSize * maxScreenRow; //576
	
	//WOLRD MAP PARAMETRES
	
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	
	//SYSTEM
	int FPS = 60;
	Sound sound = new Sound();
	KeyHandler keyHandler = new KeyHandler();
	Thread gameThread;
	public Player player = new Player(this, keyHandler);
	TileManager tileManager = new TileManager(this);
	
	public CollisionChecker collisionChecker = new CollisionChecker(this);
	public AssetHandler assetHandler = new AssetHandler(this);
	//OBJECTS
	public SuperObject objects[] = new SuperObject[10];
	
	
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true); //For better rendering performance
		this.addKeyListener(keyHandler);
		this.setFocusable(true);
	}

	public void setObjects() {
		
		assetHandler.setObject();
		
		playMusic(5);
		
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS; //1 000 000 000 == 1 second == 60 Frames Per Second
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while(gameThread != null) {
			
			
			
			currentTime = System.nanoTime();
			
			delta+= (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			
			if(delta >= 1) {
			
			update();
			
			repaint(); //calling paintComponent method here
			delta--;
			}
		}
		
	}
	
	public void update() { // update information such as char positions
		
		player.update();
		
	}
	
	public void paintComponent(Graphics graphics) { //Draw the screen with updated information
		
		super.paintComponent(graphics);
		
		Graphics2D graphics2D = (Graphics2D)graphics;
		
		tileManager.draw(graphics2D); // Gotta draw tiles first and player last since if opposite player will be hidden behind the tiles
		
		//OBJECT
		for(int i = 0; i < objects.length; i++) {
			if(objects[i] != null) {
				objects[i].draw(graphics2D, this);
			}
		}
		
		player.draw(graphics2D);
		
		
		
		graphics2D.dispose(); // dispose shit to save memory
		
	}
	
	public void playMusic(int i) {
		
		sound.setFile(i);
		sound.play();
		sound.loop();
		
	}
	public void stopMusic() {
		
		sound.stop();
	}
	public void playSoundEffect(int i) {
		
		sound.setFile(i);
		sound.play();
	}
}
