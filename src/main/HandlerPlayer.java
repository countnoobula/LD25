package main;

import java.awt.Point;

public class HandlerPlayer {

    protected GuiGame parent;
    protected int xPos = 0;
    protected int yPos = 0;
    private boolean selectedTile = false;
    private int selectedTileX = 0;
    private int selectedTileY = 0;
    private boolean commandTile = false;
    private int commandTileX = 0;
    private int commandTileY = 0;

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
        System.out.println(x + ";" + y);
        if(parent.handlerUnits.tileHasUnit(x, y)) {
            parent.handlerUnits.selectUnit(x, y);
        }
        
        parent.getMainWindow().repaint();
    }
    
    public void clearSelection() {
       selectedTile = false;
    }

    public boolean hasCommandTile() {
        return commandTile;
    }
    
    public Point getCommandTile() {
        return new Point(commandTileX, commandTileY);
    }
    
    public void commandSpot(int x, int y) {
        if(parent.handlerUnits.isUnitsSelected()) {
            
        }
    }
}