package cdg.factory;

import cdg.dao.Player;
import cdg.dao.Tile;

public class TileFactory {
    private final int width;
    private final int height;

    public TileFactory (int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Tile createLevelTile(int posX, int posY) {
        return new Tile(width, height, posX, posY);
    }

    public Player createPlayerTile(int posX, int posY, Tile[][] tileMap) {
        return new Player(width, height, posX, posY, tileMap);
    }

}
