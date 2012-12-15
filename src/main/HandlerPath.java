package main;

public class HandlerPath implements Runnable {

    protected GuiGame parent;

    public HandlerPath(GuiGame parent, int id, int initialX, int initialY, int destinationX, int destinationY) {
        this.parent = parent;
    }

    @Override
    public void run() {
    }
}