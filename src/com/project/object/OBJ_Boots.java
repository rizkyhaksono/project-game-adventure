package com.project.object;

import com.project.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class OBJ_Boots extends SuperObject{

    GamePanel gp;
    public OBJ_Boots(GamePanel gp) {

        this.gp = gp;

        name = "Boots";

        try {
            image = ImageIO.read(new FileInputStream("res/objects/boots.png"));
            uTool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
