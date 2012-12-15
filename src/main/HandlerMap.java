package main;

public class HandlerMap {

    protected GuiGame parent;
    protected int[][] currentMapArray;

    public HandlerMap(GuiGame parent) {
        this.parent = parent;
        currentMapArray = new int[15][20];
    }

    public boolean canWalk(int x, int y) {
        return true;
    }
}