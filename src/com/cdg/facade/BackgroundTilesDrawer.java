package com.cdg.facade;

import com.cdg.dao.Tile;
import com.cdg.game.LevelLayout;

import java.awt.*;
import java.util.List;

public class BackgroundTilesDrawer {
    LevelLayout levelLayout;

    public BackgroundTilesDrawer() {
        levelLayout = LevelLayout.getInstance();
    }

    public void drawBackgroundTiles(Graphics2D g2, Tile[][] tileMap) {
        int iIndex = 0;
        for(List<Integer> row : levelLayout.getLevelLayoutList()) {
            int jIndex = 0;
            for (Integer integer : row) {
                // Only drawing on background tiles
                if (integer == 0) {
                    // Logic that alternates the background's color.
                    if ((iIndex + jIndex) % 2 == 0) {
                        tileMap[iIndex][jIndex].drawMe(g2, Color.decode("#1f3d6e"), false);
                    }
                    else {
                        tileMap[iIndex][jIndex].drawMe(g2, Color.decode("#35507d"), false);
                    }
                }
                jIndex++;
            }
            iIndex++;
        }
    }
}
