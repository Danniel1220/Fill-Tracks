package com.cdg.facade;

import com.cdg.dao.Tile;
import com.cdg.io.DrawingMaster;

import java.awt.*;

public class DrawingFacade {
    private BackgroundTilesDrawer backgroundTilesDrawer = new BackgroundTilesDrawer();
    private LevelTilesDrawer levelTilesDrawer = new LevelTilesDrawer();
    private PlayerTilesDrawer playerTilesDrawer = new PlayerTilesDrawer();

    public void drawBackground(Graphics2D g2, Tile[][] tileMap) {
        backgroundTilesDrawer.drawBackgroundTiles(g2, tileMap);
    }

    public void drawLevel(Graphics2D g2, Tile[][] tileMap) {
        levelTilesDrawer.drawLevelTiles(g2, tileMap);
    }

    public void drawPlayer(Graphics2D g2, Tile[][] tileMap) {
        playerTilesDrawer.drawPlayerTile(g2, tileMap);
    }
}
