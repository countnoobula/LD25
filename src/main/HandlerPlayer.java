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
}