package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Key extends SuperObject{

	public OBJ_Key() {
		this.name = "key";
		
		try {
			this.objectImage = ImageIO.read((getClass().getResourceAsStream("/objects/key.png")));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
