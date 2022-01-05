package com.cdg.factory;

import com.cdg.dao.Tile;

import java.awt.*;

public class TileFactory {
    private final int width;
    private final int height;

    public TileFactory (int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Tile getTileObject(int posX, int posY) {
        Tile tile = new Tile(width, height, posX, posY);
        return tile;
    }

}
