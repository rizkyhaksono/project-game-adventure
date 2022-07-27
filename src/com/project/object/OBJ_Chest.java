package com.project.object;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class OBJ_Chest extends SuperObject{

    public OBJ_Chest() {

        name = "Chest";
        try {
            image = ImageIO.read(new FileInputStream("res/objects/chest.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
