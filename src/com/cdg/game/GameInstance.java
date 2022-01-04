package com.cdg.game;

import com.cdg.dao.Tile;
import com.cdg.io.DrawingMaster;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameInstance extends JPanel {
    private final int WINDOW_WIDTH = 960;
    private final int WINDOW_HEIGHT = 540;
    private final int GRIDSIZE_WIDTH = 16;
    private final int GRIDSIZE_HEIGHT = 9;

    private Tile[][] tileMap;

    private LevelLayout levelLayout;

    private DrawingMaster drawingMaster;

    public GameInstance() {
        // Level Layout Singleton.
        levelLayout = LevelLayout.getInstance();

        // Utility class for drawing.
        drawingMaster = new DrawingMaster();

        // TileMap array.
        tileMap = new Tile[GRIDSIZE_HEIGHT][GRIDSIZE_WIDTH];

        // Prints out the level layout for debugging purposes
        for(List<Integer> row : levelLayout.getLevelLayoutList()) {
            for (Integer i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        // Creates the tileMap Array
        int iIndex = 0;
        for(List<Integer> row : levelLayout.getLevelLayoutList()) {
            int jIndex = 0;
            for (Integer i : row) {
                Tile tile = new Tile(
                        WINDOW_WIDTH / GRIDSIZE_WIDTH,
                        WINDOW_WIDTH / GRIDSIZE_WIDTH,
                        jIndex * (WINDOW_WIDTH / GRIDSIZE_WIDTH),
                        iIndex * (WINDOW_WIDTH / GRIDSIZE_WIDTH));
                tileMap[iIndex][jIndex] = tile;
                this.add(tile);
                jIndex++;
            }
            iIndex++;
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Draw background tiles on the screen according to the tileMap.
        drawingMaster.drawBackgroundTiles(g2, tileMap);

        // Draw playable map tiles on the screen according to the tilemap.
        drawingMaster.drawLevelTiles(g2, tileMap);

        // Draw player tile.
        drawingMaster.drawPlayerTile(g2, tileMap);

        repaint();
        g.dispose();

        //System.out.println("drawn...");
    }

    // DRAWING INSTRUCTIONS:
    // 0 : BACKGROUND TILE
    // 1 : PLAYABLE MAP TILE
    // 2 : PLAYABLE MAP TILE / PLAYER TILE


}
