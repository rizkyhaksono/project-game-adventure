package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Chest extends SuperObject{

	
	public OBJ_Chest() {
		this.name = "Chest";
		
		try {
			this.objectImage = ImageIO.read((getClass().getResourceAsStream("/objects/chest.png")));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
