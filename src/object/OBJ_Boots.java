package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Boots extends SuperObject{

	public OBJ_Boots() {
		this.name = "boots";
		
		try {
			this.objectImage = ImageIO.read((getClass().getResourceAsStream("/objects/boots.png")));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
