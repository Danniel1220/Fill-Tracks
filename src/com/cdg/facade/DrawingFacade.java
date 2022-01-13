package com.cdg.facade;

import com.cdg.dao.Tile;

import java.awt.*;

public class DrawingFacade {
    private final BackgroundTilesDrawer backgroundTilesDrawer = new BackgroundTilesDrawer();
    private final LevelTilesDrawer levelTilesDrawer = new LevelTilesDrawer();
    private final PlayerTilesDrawer playerTilesDrawer = new PlayerTilesDrawer();

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
