package main;

public class HandlerPlayer {

    protected GuiGame parent;
    protected int xPos = 0;
    protected int yPos = 0;

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

    public void selectSpot(int x, int y) {
        System.out.println(x + ";" + y);
        if(parent.handlerUnits.tileHasUnit(x, y)) {
            if(parent.handlerUnits.isFriendly(x+xPos, y+yPos)) {
                parent.handlerUnits.selectUnit(x, y);
            }
        } else {
            parent.handlerUnits.deselectAll();
        }
        
        parent.getMainWindow().repaint();
    }
    
    public void commandSpot(int x, int y) {
        if(parent.handlerUnits.isUnitsSelected()) {
            if(parent.handlerUnits.isOccupied((x+parent.handlerPlayer.xPos), (y+parent.handlerPlayer.yPos))) {
                if(parent.handlerUnits.isFriendly(x+parent.handlerPlayer.xPos, y+parent.handlerPlayer.yPos)) {
                    parent.handlerUnits.moveSelected((x+parent.handlerPlayer.xPos), (y+parent.handlerPlayer.yPos));
                } else {
                    parent.handlerUnits.attackSelected((x+parent.handlerPlayer.xPos), (y+parent.handlerPlayer.yPos));
                }
            } else {
                parent.handlerUnits.moveSelected((x+parent.handlerPlayer.xPos), (y+parent.handlerPlayer.yPos));
            }
        }
    }
}