package cdg.junit;

import cdg.dao.MovementDirection;
import cdg.dao.Tile;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest extends Tile {
    LevelLayoutTest levelLayout = LevelLayoutTest.getInstance();

    public PlayerTest() {
        super(60, 60, 0, 0);
    }

    @Test
    public void traverseMapCase1() {

        List<List<Integer>> levelLayoutList = levelLayout.getLevelLayoutList();

        MovementDirection direction = MovementDirection.LEFT;

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

        List<List<Integer>> levelLayoutListAfterMove = new ArrayList<>();

        // Player's position after move should be
        Point newPlayerPosition = new Point(4, 5);

        assertEquals(newPlayerPosition, playerPosition);
    }

    @Test
    public void traverseMapCase2() {

        List<List<Integer>> levelLayoutList = levelLayout.getLevelLayoutList();

        MovementDirection direction = MovementDirection.RIGHT;

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

        List<List<Integer>> levelLayoutListAfterMove = new ArrayList<>();

        // Player's position after move should be
        Point newPlayerPosition = new Point(4, 5);

        assertEquals(newPlayerPosition, playerPosition);
    }

    @Test
    public void traverseMapCase3() {

        List<List<Integer>> levelLayoutList = levelLayout.getLevelLayoutList();

        MovementDirection direction = MovementDirection.LEFT;

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

        List<List<Integer>> levelLayoutListAfterMove = new ArrayList<>();

        // Player's position after move should be
        Point newPlayerPosition = new Point(4, 5);

        assertEquals(newPlayerPosition, playerPosition);
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
        int tileMapWidth = 16;
        int tileMapHeight = 9;
        inBounds = ((newPlayerPosition.x >= 0) && (newPlayerPosition.x < tileMapWidth) && (newPlayerPosition.y >= 0 && newPlayerPosition.y < tileMapHeight));
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
}