package com.cdg.facade;

import com.cdg.dao.Tile;
import com.cdg.game.LevelLayout;

import java.awt.*;
import java.util.List;

public class LevelTilesDrawer {
    LevelLayout levelLayout;

    public LevelTilesDrawer() {
        levelLayout = LevelLayout.getInstance();
    }

    public void drawLevelTiles(Graphics2D g2, Tile[][] tileMap) {
        int iIndex = 0;
        for(List<Integer> row : levelLayout.getLevelLayoutList()) {
            int jIndex = 0;
            for (Integer integer : row) {
                // Only drawing the playable map tiles.
                if (integer == 1) {
                    tileMap[iIndex][jIndex].drawMe(g2, Color.decode("#c86a37"), true);
                }
                jIndex++;
            }
            iIndex++;
        }
    }
}
