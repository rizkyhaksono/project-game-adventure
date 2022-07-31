package com.project.main;

import com.project.entity.NPC_OldMan;
import com.project.object.OBJ_Boots;
import com.project.object.OBJ_Chest;
import com.project.object.OBJ_Door;
import com.project.object.OBJ_Key;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

    }

    public void setNPC() {

        gp.npc[0] = new NPC_OldMan(gp);
        gp.npc[0].worldX = gp.tileSize * 21;
        gp.npc[0].worldY = gp.tileSize * 21;
    }
}
