package com.project.object;

import com.project.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class OBJ_Key extends SuperObject{

    GamePanel gp;
    public OBJ_Key(GamePanel gp) {

        this.gp = gp;

        name = "Key";
        try {
            image = ImageIO.read(new FileInputStream("res/objects/key.png"));
            uTool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        solidArea.x = 5;
    }
}
