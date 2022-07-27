package com.project.object;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class OBJ_Boots extends SuperObject{

    public OBJ_Boots() {

        name = "Boots";

        try {
            image = ImageIO.read(new FileInputStream("res/objects/boots.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
