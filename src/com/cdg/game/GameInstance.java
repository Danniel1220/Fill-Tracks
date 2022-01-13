package com.cdg.game;

import com.cdg.dao.MovementDirection;
import com.cdg.dao.Player;
import com.cdg.dao.Tile;
import com.cdg.facade.DrawingFacade;
import com.cdg.factory.TileFactory;
import com.cdg.io.FileInputManager;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameInstance extends JPanel {
    private final int WINDOW_WIDTH = 960;
    private final int WINDOW_HEIGHT = 540;
    private final int GRIDSIZE_WIDTH = 16;
    private final int GRIDSIZE_HEIGHT = 9;

    private Tile[][] tileMap = new Tile[GRIDSIZE_HEIGHT][GRIDSIZE_WIDTH];

    private final DrawingFacade drawingFacade = new DrawingFacade();
    private final LevelLayout levelLayout = LevelLayout.getInstance();
    private final FileInputManager fileInputManager = new FileInputManager();
    private final TileFactory tileFactory = new TileFactory(WINDOW_WIDTH / GRIDSIZE_WIDTH, WINDOW_HEIGHT / GRIDSIZE_HEIGHT);

    private final Player player = tileFactory.createPlayerTile(0, 0, tileMap);

    private int currentLevel = 1;

    public GameInstance() {
        fetchLevel();
        updateTileMap();
    }

    private void fetchLevel() {
        levelLayout.setLevelLayoutList(fileInputManager.readLevelLayout("Levels/" + currentLevel));
    }

    private boolean isLevelComplete() {
        boolean isComplete = true;

        for(List<Integer> row : levelLayout.getLevelLayoutList()) {
            for (Integer i : row) {
                // If there are still any playable tiles left unvisited
                if (i == 1) {
                    isComplete = false;
                    break;
                }
            }
        }
        return isComplete;
    }

    private void updateTileMap() {
        TileFactory factory = new TileFactory(WINDOW_WIDTH / GRIDSIZE_WIDTH, WINDOW_HEIGHT / GRIDSIZE_HEIGHT);
        // Updates the tileMap array with whatever is inside the levelLayout singleton.
        int iIndex = 0;
        for(List<Integer> row : levelLayout.getLevelLayoutList()) {
            int jIndex = 0;
            for (Integer integer : row) {
                Tile tile = tileFactory.createLevelTile(jIndex * (WINDOW_WIDTH / GRIDSIZE_WIDTH), iIndex * (WINDOW_WIDTH / GRIDSIZE_WIDTH));
                tileMap[iIndex][jIndex] = tile;
                jIndex++;
            }
            iIndex++;
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Draw background tiles on the screen according to the tileMap.
        drawingFacade.drawBackground(g2, tileMap);

        // Draw playable map tiles on the screen according to the tilemap.
        drawingFacade.drawLevel(g2, tileMap);

        // Draw player tile.
        drawingFacade.drawPlayer(g2, tileMap);

        g.dispose();

        System.out.println("drawn...");
    }

    public void input(MovementDirection direction) {
        player.input(direction);
        repaint();

        if (isLevelComplete()) {
            currentLevel++;
            fetchLevel();
            updateTileMap();
        }
    }
}
