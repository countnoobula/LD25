package main;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class Tile {

    protected HandlerTiles parent;
    protected BufferedImage texture;
    
    public Tile(HandlerTiles parent) {
    }
    
    public boolean isPassable() {
        return false;
    }
    
    public int getID() {
        return 0;
    }
    
    public Image getTexture() {
        return texture;
    }
    
    public String getName() {
        return "";
    }
}