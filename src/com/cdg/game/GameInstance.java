package com.cdg.game;

import com.cdg.dao.Square;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameInstance extends JPanel {
    private final int WINDOW_WIDTH = 960;
    private final int WINDOW_HEIGHT = 540;
    private final int GRIDSIZE_WIDTH = 16;
    private final int GRIDSIZE_HEIGHT = 9;

    private Square[][] tileMap;

    private LevelLayout levelLayout;

    public GameInstance() {
        // Level Layout Singleton
        levelLayout = LevelLayout.getInstance();

        // TileMap Array
        tileMap = new Square[GRIDSIZE_HEIGHT][GRIDSIZE_WIDTH];

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
                Square square = new Square(
                        WINDOW_WIDTH / GRIDSIZE_WIDTH,
                        WINDOW_WIDTH / GRIDSIZE_WIDTH,
                        jIndex * (WINDOW_WIDTH / GRIDSIZE_WIDTH),
                        iIndex * (WINDOW_WIDTH / GRIDSIZE_WIDTH));
                tileMap[iIndex][jIndex] = square;
                this.add(square);
                jIndex++;
            }
            iIndex++;
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Draw background tiles on the screen according to the tileMap.
        drawBackgroundTiles(g2);

        // Draw playable map tiles on the screen according to the tilemap.
        drawLevelTiles(g2);

        repaint();
        g.dispose();

        //System.out.println("drawn...");
    }

    // DRAWING INSTRUCTIONS:
    // 0 : BACKGROUND TILE
    // 1 : PLAYABLE MAP TILE
    // 2 : PLAYABLE MAP TILE / PLAYER TILE

    private void drawBackgroundTiles(Graphics2D g2) {
        int iIndex = 0;
        for(List<Integer> row : levelLayout.getLevelLayoutList()) {
            int jIndex = 0;
            for (Integer i : row) {
                // Logic that alternates the background's color.
                if ((iIndex + jIndex) % 2 == 0) {
                    tileMap[iIndex][jIndex].drawMe(g2, Color.decode("#1f3d6e"), false);
                }
                else {
                    tileMap[iIndex][jIndex].drawMe(g2, Color.decode("#35507d"), false);
                }
                jIndex++;
            }
            iIndex++;
        }
    }

    private void drawLevelTiles(Graphics2D g2) {
        int iIndex = 0;
        for(List<Integer> row : levelLayout.getLevelLayoutList()) {
            int jIndex = 0;
            for (Integer i : row) {
                // Only drawing the playable map tiles.
                if (i == 1 || i == 2) {
                    tileMap[iIndex][jIndex].drawMe(g2, Color.decode("#c86a37"), true);
                }
                jIndex++;
            }
            iIndex++;
        }
    }

    private void drawPlayerTile(Graphics2D g2) {
        int iIndex = 0;
        for(List<Integer> row : levelLayout.getLevelLayoutList()) {
            int jIndex = 0;
            for (Integer i : row) {
                // Only drawing the playable map tiles.
                if (i == 1 || i == 2) {
                    tileMap[iIndex][jIndex].drawMe(g2, Color.decode("#c86a37"), true);
                }
                jIndex++;
            }
            iIndex++;
        }
    }
}
