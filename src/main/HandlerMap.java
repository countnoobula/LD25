package main;

public class HandlerMap {

    public GuiGame parent;

    public HandlerMap(GuiGame parent) {
        this.parent = parent;
    }

    public boolean canWalk(int x, int y) {
        return true;
    }
}