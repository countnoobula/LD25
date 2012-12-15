package main;

import java.awt.Point;

public class HandlerPlayer {

    protected GuiGame parent;
    protected int xPos = 0;
    protected int yPos = 0;
    private boolean selectedTile = false;
    private int selectedTileX = 0;
    private int selectedTileY = 0;
    
    public HandlerPlayer(GuiGame parent) {
        this.parent = parent;
    }

    public void moveUp() {
        if(xPos != 0) {
            xPos--;
        }
        parent.handlerMap.makeDirty();
    }

    public void moveDown() {
        if(xPos != 49) {
            xPos++;
        }
        parent.handlerMap.makeDirty();
    }

    public void moveLeft() {
        if(yPos != 0) {
            yPos--;
        }
        parent.handlerMap.makeDirty();
    }

    public void moveRight() {        
        if(yPos != 49) {
            yPos++;
        }
        parent.handlerMap.makeDirty();
    }
    
    public boolean hasSelectedTile() {
        return selectedTile;
    }
    
    public Point getSelectedTile() {
        return new Point(selectedTileX, selectedTileY);
    }
    
    public void selectSpot(int x, int y) {
        selectedTileX = x; 
        selectedTileY = y;
        selectedTile = true;
        parent.getMainWindow().repaint();
    }
}