package cdg.facade;

import cdg.dao.Tile;
import cdg.game.LevelLayout;

import java.awt.*;
import java.util.List;

public class PlayerTilesDrawer {
    LevelLayout levelLayout;

    public PlayerTilesDrawer() {
        levelLayout = LevelLayout.getInstance();
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
