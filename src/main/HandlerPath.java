package main;

public class HandlerPath implements Runnable {

    protected GuiGame parent;

    public HandlerPath(GuiGame parent, Unit unit, int initialY, int initialX, int destinationX, int destinationY) {
        this.parent = parent;
        System.out.println("Moving from " + initialX + ";" + initialY + " to " + destinationX + ";" + destinationY);
    }

    @Override
    public void run() {
        System.out.println("Movement started");
    }
}