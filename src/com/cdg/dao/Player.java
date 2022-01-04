package com.cdg.dao;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Tile {

    public Player(int width, int height, int positionX, int positionY) {
        super(width, height, positionX, positionY);
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
