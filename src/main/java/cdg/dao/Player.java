package cdg.dao;

import cdg.game.LevelLayout;

import java.awt.*;
import java.util.List;

public class Player extends Tile {
    private Tile[][] tileMap;
    LevelLayout levelLayout = LevelLayout.getInstance();

    public Player(int width, int height, int positionX, int positionY, Tile[][] tileMap) {
        super(width, height, positionX, positionY);
        this.tileMap = tileMap;
    }

    public void input(MovementDirection direction) {
        System.out.println("Received input: " + direction);
        traverseMap(direction);
    }

    private void traverseMap(MovementDirection direction) {
        List<List<Integer>> levelLayoutList = levelLayout.getLevelLayoutList();
        Point playerPosition = findPlayerPosition();

        // While we are able to move in a certain direction, continue to do so
        while (moveDirectionIsValid(direction, playerPosition)) {
            switch (direction) {
                case UP:
                    movePlayer(playerPosition, new Point(playerPosition.x - 1, playerPosition.y));
                    playerPosition = new Point(playerPosition.x - 1, playerPosition.y);
                    break;
                case DOWN:
                    movePlayer(playerPosition, new Point(playerPosition.x + 1, playerPosition.y));
                    playerPosition = new Point(playerPosition.x + 1, playerPosition.y);
                    break;
                case LEFT:
                    movePlayer(playerPosition, new Point(playerPosition.x, playerPosition.y - 1));
                    playerPosition = new Point(playerPosition.x, playerPosition.y - 1);
                    break;
                case RIGHT:
                    movePlayer(playerPosition, new Point(playerPosition.x, playerPosition.y + 1));
                    playerPosition = new Point(playerPosition.x, playerPosition.y + 1);
                    break;
            }
        }
    }

    private void movePlayer(Point currentPosition, Point newPosition) {
        levelLayout.setValueInLevelLayoutList(currentPosition.x, currentPosition.y, 2);
        levelLayout.setValueInLevelLayoutList(newPosition.x, newPosition.y, 3);

        System.out.println("Moved player to position: " + newPosition.x + " " + newPosition.y);
    }

    private boolean moveDirectionIsValid(MovementDirection direction, Point playerPosition) {
        Point newPlayerPosition;

        // New point to check in the specified direction
        switch (direction)
        {
            case UP:
                newPlayerPosition = new Point(playerPosition.x - 1, playerPosition.y);
                break;
            case DOWN:
                newPlayerPosition = new Point(playerPosition.x + 1, playerPosition.y);
                break;
            case LEFT:
                newPlayerPosition = new Point(playerPosition.x, playerPosition.y - 1);
                break;
            case RIGHT:
                newPlayerPosition = new Point(playerPosition.x, playerPosition.y + 1);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        }

        boolean inBounds = false;
        boolean onPlayableTile = false;

        // If the new point is within the level as a whole
        inBounds = ((newPlayerPosition.x >= 0) && (newPlayerPosition.x < tileMap.length) && (newPlayerPosition.y >= 0 && newPlayerPosition.y < tileMap[0].length));
        // If it is in bounds, also check if it's on a playable tile
        if (inBounds) {
            onPlayableTile = (levelLayout.getValueFromLevelLayoutList(newPlayerPosition.x, newPlayerPosition.y) == 1);
        }

        // Return if the new move is going to be made on a playable tile or not.
        return onPlayableTile;
    }

    private Point findPlayerPosition() {
        int iIndex = 0;
        for(List<Integer> row : levelLayout.getLevelLayoutList()) {
            int jIndex = 0;
            for (Integer integer : row) {
                // Only drawing on background tiles
                if (integer == 3) {
                    // Found player position.
                    return new Point(iIndex, jIndex);
                }
                jIndex++;
            }
            iIndex++;
        }
        return new Point(-1, -1);
    }

//    public void drawMe(Graphics2D g, Color color, boolean hasOutline) {
//        // If hasOutline is true we set the stroke's thickness to 2, otherwise 0 for no outline.
//        if (hasOutline) {
//            g.setStroke(new BasicStroke(2));
//        } else {
//            g.setStroke(new BasicStroke(0));
//        }
//
//        // Outline is always white
//        g.setColor(Color.WHITE);
//        g.draw(this.getRect());
//
//        // Drawing the actual rectangle
//        g.setColor(color);
//        g.fillRect(this.getPositionX(), this.getPositionY(), this.getWidth(), this.getHeight());
//    }
}
