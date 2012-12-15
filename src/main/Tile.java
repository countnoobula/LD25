package main;

import java.awt.Image;

public class Tile {

    protected HandlerTiles parent;
    protected Image texture;
    
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
}
