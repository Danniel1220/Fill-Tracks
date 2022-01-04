package com.cdg.io;

import com.cdg.dao.Tile;
import com.cdg.game.LevelLayout;

import java.awt.*;
import java.util.List;

public class DrawingMaster {
    LevelLayout levelLayout;

    public DrawingMaster() {
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

    public void drawPlayerTile(Graphics2D g2, Tile[][] tileMap) {
        int iIndex = 0;
        for(List<Integer> row : levelLayout.getLevelLayoutList()) {
            int jIndex = 0;
            for (Integer integer : row) {
                // Only drawing player tiles
                if (integer == 2 || integer == 3) {
                    tileMap[iIndex][jIndex].drawMe(g2, Color.decode("#282760"), true);
                }
                jIndex++;
            }
            iIndex++;
        }
    }
}
