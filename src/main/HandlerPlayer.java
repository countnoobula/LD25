package main;

public class HandlerPlayer {

    protected GuiGame parent;
    protected int xPos = 0;
    protected int yPos = 0;

    public HandlerPlayer(GuiGame parent) {
        this.parent = parent;
    }

    public void moveUp() {
        if(parent.handlerMap.canWalk(xPos, yPos - 1)) {
            yPos--;
        }
    }

    public void moveDown() {
        if(parent.handlerMap.canWalk(xPos, yPos + 1)) {
            yPos++;
        }
    }

    public void moveLeft() {
        if(parent.handlerMap.canWalk(xPos - 1, yPos)) {
            xPos--;
        }
    }

    public void moveRight() {
        if(parent.handlerMap.canWalk(xPos + 1, yPos)) {
            xPos++;
        }
    }
}