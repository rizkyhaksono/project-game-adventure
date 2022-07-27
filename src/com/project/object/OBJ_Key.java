package com.project.object;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class OBJ_Key extends SuperObject{

    public OBJ_Key() {

        name = "Key";
        try {
            image = ImageIO.read(new FileInputStream("res/objects/key.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        solidArea.x = 5;
    }
}
